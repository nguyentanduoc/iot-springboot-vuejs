import Vue from 'vue'
import Vuex from 'vuex'
import themeModule from './modules/themeModule'
import userModule from './modules/userModule'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    themeModule,
    userModule
  }
})
