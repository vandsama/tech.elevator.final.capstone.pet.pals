import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import petRegistration from '../views/PetRegistration'
import playDateList from '../components/PlayDateList.vue'

import Messages from '../views/ForumViews/Messages.vue';
import AddMessage from '../views/ForumViews/AddMessage.vue';
import AddTopic from '../views/ForumViews/AddTopic.vue';
import EditTopic from '../views/ForumViews/EditTopic.vue';
import NotFound from '../views/ForumViews/NotFound.vue';
import EditMessage from '../views/ForumViews/EditMessage';

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/pets/register",
      name: "petRegistration",
      component: petRegistration,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/playdates",
      name: "playDates",
      component: playDateList,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/not-found",
      name: "NotFound",
      component: NotFound
    },
    {
      path: '/add-topic',
      name: 'AddTopic',
      component: AddTopic
    },
    {
      path: '/edit-topic/:id',
      name: 'EditTopic',
      component: EditTopic
    },
    {
      path: '/:id',
      name: 'Messages',
      component: Messages
    },
    {
      path: '/:topicId/add-message',
      name: 'AddMessage',
      component: AddMessage
    },
    {
      path: '/:topicId/edit-message/:messageId',
      name: 'EditMessage',
      component: EditMessage
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
