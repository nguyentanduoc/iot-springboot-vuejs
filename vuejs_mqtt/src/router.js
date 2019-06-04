import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('./views/About.vue')
    },
    {
      path: '/map',
      name: 'map',
      component: () => import('./views/Map.vue')
    },
    {
      path: '/map-leaflet',
      name: 'leaflet',
      component: () => import('./views/MapLeafLet.vue')
    },
    {
      path: '/basic',
      name: 'basic',
      component: () => import('./views/Basic.vue')
    },
    {
      path: '/implement-map',
      name: 'implementMap',
      component: () => import('./views/ImplementMap.vue')
    },
    {
      path: '/vuelayers',
      name: 'vuelayers',
      component: () => import('./views/VueLayers.vue')
    }
  ]
})
