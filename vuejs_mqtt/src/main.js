import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueMqtt from 'vue-mqtt'
import VueLogger from 'vuejs-logger'
import './assets/styles/main.css'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import '../registerServiceWorker'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'font-awesome/css/font-awesome.css'
import './assets/styles/default.styl'

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
const optionsMqtt = {
  clientId: 'WebClient-' + parseInt(Math.random() * 100000),
  username: 'zddelmko',
  password: 'NQ-HVjwgF3v1'
};

Vue.config.productionTip = false;
Vue.use(VueLogger, options);
Vue.use(VueMqtt, 'wss://m10.cloudmqtt.com:38332', optionsMqtt);
Vue.use(Vuetify, {
  theme: {
    primary: '#ee44aa',
    secondary: '#424242',
    accent: '#82B1FF',
    error: '#FF5252',
    info: '#2196F3',
    success: '#4CAF50',
    warning: '#FFC107'
  },
  customProperties: true,
  iconfont: 'fa4',
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
