import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';

import App from './App.vue';
import BaseCard from './components/UI/BaseCard.vue';
import TheCart from './components/TheCart.vue';
import HelloWorld from './components/HelloWorld.vue';
import ProductDetail from './components/Layout/ProductDetail.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/cart',component: TheCart },  //localhost:3000/cart => ....
        { path: '/',component: HelloWorld },
        { path: '/product/:id',component: ProductDetail, name: 'product' },
    ]
});

const app = createApp(App);
app.component('base-card', BaseCard);
app.use(router);

app.mount('#app');
