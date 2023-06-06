<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="id">商品編號</label>
        <input
            type="text"
            class="form-control"
            id="id"
            required
            v-model="product.id"
            name="id"
        />
      </div>
      <div class="form-group">
        <label for="name">商品名稱</label>
        <input
            type="text"
            class="form-control"
            id="name"
            required
            v-model="product.name"
            name="name"
        />
      </div>

      <div class="form-group">
        <label for="price">售價</label>
        <input
            class="form-control"
            id="price"
            required
            v-model="product.price"
            name="price"
        />
      </div>

      <div class="form-group">
        <label for="stock">庫存</label>
        <input
            class="form-control"
            id="stock"
            required
            v-model="product.stock"
            name="stock"
        />
      </div>

      <button @click="saveProduct" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newProduct">Add</button>
    </div>
  </div>
</template>

<script>

import ProductServices from "@/services/ProductServices";

export default {
  name: "add-product",
  data() {
    return {
      product: {
        id: null,
        name: "",
        price: null,
        stock: null
      },
      submitted: false
    };
  },
  methods: {
    saveProduct() {
      const data = {
        id:this.product.id,
        name: this.product.name,
        price: this.product.price,
        stock:this.product.stock
      };

      ProductServices.create(data)
          .then(response => {
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
    },

    newProduct() {
      this.submitted = false;
      this.product = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>
