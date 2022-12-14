import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import moment from 'moment'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { faMapPin } from '@fortawesome/free-solid-svg-icons'
import { faCalendarDays } from '@fortawesome/free-solid-svg-icons'
import { faClock } from '@fortawesome/free-solid-svg-icons'
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'

library.add(faUserSecret, faMapPin, faCalendarDays, faClock, faMagnifyingGlass)

Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.config.productionTip = false



axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.filter('formatDate', function (value) {
  if (value) {
    return moment(String(value)).format('MMMM Do YYYY')
  }
})

Vue.filter('formatTime', function (value) {
  if (value) {
    return moment(String(value)).format('h:mm a')
  }
})

new Vue({
  router,
  store,
  render: h => h(App),
  el: '#app',
  components: { App },
  template: '<App/>',
}).$mount('#app')


