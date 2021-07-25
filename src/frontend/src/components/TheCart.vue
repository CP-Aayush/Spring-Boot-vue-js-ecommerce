<template>
  <ul>
  <li v-for="content in contents" :key="content.id">
    <!-- <img :src="content.imgSource"/> -->
    <base-card>
      <h2>{{ content.productId.name }}</h2>
      <p>{{ content.description}}</p>
      <h1>{{ content.quantity}}</h1>
    </base-card>
  </li>
  </ul>
</template>

<script>
import axios from 'axios';
export default {
  name: 'HelloWorld',
  data() {
    return{
      contents: null
    }
  },
  mounted() {
     axios
      .get('/api/cart')
      .then(response => (this.contents = response.data))
}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
  width: 300px;
}
</style>
