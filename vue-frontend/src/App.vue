<template>
  <div id="app">
    <nav className="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" className="navbar-brand">product</router-link>
      <div className="navbar-nav mr-auto">
        <li className="nav-item">
          <router-link to="/product" className="nav-link">product</router-link>
        </li>
        <li className="nav-item">
          <router-link to="/add" className="nav-link">Add</router-link>
        </li>
      </div>
    </nav>

    <div className="container mt-3">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>