import Vue from 'vue';
import Vuex from 'vuex';
import themeModule from './modules/themeModule';
import registerModule from './modules/registerModule';
import loadingModule from './modules/loadingModule';
import alertModule from './modules/alertModule';
import loginModule from './modules/loginModule';
import roleModule from './modules/roleModule';
import accountModule from './modules/accountModule';
import sensorModule from './modules/sensorModule';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    themeModule,
    registerModule,
    loadingModule,
    alertModule,
    loginModule,
    roleModule,
    accountModule,
    sensorModule
  }
})
