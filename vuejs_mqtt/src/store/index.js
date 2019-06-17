import Vue from 'vue';
import Vuex from 'vuex';
import themeModule from './modules/themeModule';
import registerModule from './modules/registerModule';
import loadingModule from './modules/loadingModule';
import alertModule from './modules/alertModule';
import loginModule from './modules/loginModule'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    themeModule,
    registerModule,
    loadingModule,
    alertModule,
    loginModule
  }
})
