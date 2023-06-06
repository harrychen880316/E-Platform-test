<template>
  <div v-if="currentProduct" class="edit-form">
    <h4>Tutorial</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
               v-model="currentProduct.title"
        />
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description"
               v-model="currentProduct.description"
        />
      </div>

      <div class="form-group">
        <label><strong>Status:</strong></label>
        {{ currentProduct.published ? "Published" : "Pending" }}
      </div>
    </form>

    <button class="badge badge-primary mr-2"
            v-if="currentProduct.published"
            @click="updatePublished(false)"
    >
      UnPublish
    </button>
    <button v-else class="badge badge-primary mr-2"
            @click="updatePublished(true)"
    >
      Publish
    </button>

    <button class="badge badge-danger mr-2"
            @click="deleteProduct"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
            @click="updateProduct"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Tutorial...</p>
  </div>
</template>

<script>
import ProductServices from "@/services/ProductServices";

export default {
  name: "productIndex",
  data() {
    return {
      currentProduct: null,
      message: ''
    };
  },
  methods: {
    getProduct(id) {
      ProductServices.get(id)
          .then(response => {
            this.currentProduct = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    updatePublished(status) {
      const data = {
        id: this.currentProduct.id,
        name: this.currentProduct.name,
        price: this.currentProduct.price,
        stock: this.currentProduct.stock
      };

      ProductServices.update(this.currentProduct.id, data)
          .then(response => {
            console.log(response.data);
            this.currentProduct.stock = status;
            this.message = 'The status was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    },

    updateProduct() {
      ProductServices.update(this.currentProduct.id, this.currentProduct)
          .then(response => {
            console.log(response.data);
            this.message = 'The product was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
    },

    deleteProduct() {
      ProductServices.delete(this.currentProduct.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "product" });
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.message = '';
    this.getProduct(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
