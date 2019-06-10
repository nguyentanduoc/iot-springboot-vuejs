import Vue from 'vue'
import Router from 'vue-router'
import store from './store'

Vue.use(Router);

const requireAuth = (to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth) && !store.state.isLogin) {
    next('/pages/login');
  } else {
    next();
  }
};


export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/home',
      name: 'DefaultLayout',
      component: () => import('./containers/DefaultLayout'),
      meta: {requiresAuth: true},
      beforeEnter: requireAuth,
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
          component: () => import('./views/Register'),
        }
      ]
    },
    {
      name: 'NotFound',
      path: '/404',
      component: () => import('./views/404'),
    },
    {
      name: 'AccessDenied',
      path: '/404',
      component: () => import('./views/404'),
    },
    {
      name: 'ServerError',
      path: '/404',
      component: () => import('./views/404'),
    },
    {
      path: "*",
      redirect: '404'
    },
  ]
});