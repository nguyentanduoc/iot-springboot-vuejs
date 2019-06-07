import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/home',
      name: 'DefaultLayout',
      component: () => import('./containers/DefaultLayout'),
      children: [
        {
          path: 'home',
          name: 'home',
          component: () => import('./views/Home'),
        },
        {
          path: 'map',
          name: 'map',
          component: () => import('./views/Map'),
        },
      ]
    },
    {
      path: '/pages',
      redirect: '/pages/404',
      name: 'Pages',
      component: {
        render(c) {
          return c('router-view')
        }
      },
      children: [
        {
          path: 'login',
          name: 'Login',
          component: () => import('./views/Login'),
        },
        {
          path: 'register',
          name: 'Register',
          component: () => import('./views/Login'),
        }
      ]
    },
    {path: "*", component: () => import('./views/404')}
  ]
})
