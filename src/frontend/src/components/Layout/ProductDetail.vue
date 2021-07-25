<template>
    
    <h1>{{contents}}</h1>
 
</template>

<script>
import axios from 'axios';
export default {
  name: 'ProductDetail',
  data() {
    return{
      contents: null
    }
  },
  mounted() {
 axios
      .get('/api/products/'+this.$route.params.id)
      .then(response => (console.log(response.data)));

     axios
      .get('/api/products/'+this.$route.params.id)
      .then(response => (this.contents = response.data));

     
}
}
</script>