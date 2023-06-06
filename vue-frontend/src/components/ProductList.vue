<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by title"
               v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
                  @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Product List</h4>
      <ul class="list-group">
        <li class="list-group-item"
            :class="{ active: index == currentIndex }"
            v-for="(product, index) in product"
            :key="index"
            @click="setActiveProduct(product, index)"
        >
          {{ product.name }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllProduct">
        Remove All
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentProduct">
        <h4>商品</h4>
        <div>
          <label><strong>商品名稱:</strong></label> {{ currentProduct.name }}
        </div>
        <div>
          <label><strong>價錢:</strong></label> {{ currentProduct.price }}
        </div>
        <div>
          <label><strong>庫存:</strong></label> {{ currentProduct.stock }}
        </div>

        <router-link :to="'/product/' + currentProduct.id" class="badge badge-warning">Edit</router-link>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Product...</p>
      </div>
    </div>
  </div>
</template>

<script>
import ProductServices from "@/services/ProductServices";

export default {
  name: "product-list",
  data() {
    return {
      product: [],
      currentProduct: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieveProduct() {
      ProductServices.getAll()
          .then(response => {
            this.product = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    refreshList() {
      this.retrieveProduct();
      this.currentProduct = null;
      this.currentIndex = -1;
    },

    setActiveProduct(product, index) {
      this.currentProduct = product;
      this.currentIndex = product ? index : -1;
    },

    removeAllProduct() {
      ProductServices.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
    },

    searchTitle() {
      ProductServices.findByTitle(this.title)
          .then(response => {
            this.product = response.data;
            this.setActiveProduct(null);
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.retrieveProduct();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
