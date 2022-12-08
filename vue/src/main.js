import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import moment from 'moment'

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.filter('formatDate', function(value) {
  if (value) {
    return moment(String(value)).format('MMMM Do YYYY')
  }
})

Vue.filter('formatTime', function(value) {
  if (value) {
    return moment(String(value)).format('h:mm:ss a')
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
