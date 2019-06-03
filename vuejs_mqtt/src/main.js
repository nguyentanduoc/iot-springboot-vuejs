import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueMqtt from 'vue-mqtt'
import VueLogger from 'vuejs-logger'

const isProduction = process.env.NODE_ENV === 'production';

const options = {
  isEnabled: true,
  logLevel: isProduction ? 'error' : 'debug',
  stringifyArguments: false,
  showLogLevel: true,
  showMethodName: true,
  separator: '|',
  showConsoleColors: true
};

Vue.use(VueLogger, options);
Vue.config.productionTip = false;
const optionsMqtt = {
  clientId: 'WebClient-' + parseInt(Math.random() * 100000),
  username: 'zddelmko',
  password: 'NQ-HVjwgF3v1'
};
Vue.use(VueMqtt, 'wss://m10.cloudmqtt.com:38332', optionsMqtt);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
