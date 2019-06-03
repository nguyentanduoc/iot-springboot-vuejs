import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueMqtt from 'vue-mqtt'
import VueLogger from 'vuejs-logger'
import('./assets/styles/main.css');
// import VueMapbox from "vue-mapbox";
// import Mapbox from "mapbox-gl"

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
// Vue.use(VueMapbox, { mapboxgl: Mapbox });
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
