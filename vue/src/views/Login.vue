<template>
  <html>
    <section>
      <div id="login" class="text-center">
        <form class="form-signin" @submit.prevent="login">
          <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
          <div
            class="alert alert-danger"
            role="alert"
            v-if="invalidCredentials"
          >
            Invalid username and password!
          </div>
          <div
            class="alert alert-success"
            role="alert"
            v-if="this.$route.query.registration"
          >
            Thank you for registering, please sign in.
          </div>
          <div class="username">
            <label for="username" class="sr-only">Username </label>
            <input
              type="text"
              id="username"
              class="form-control"
              placeholder="Username"
              v-model="user.username"
              required
              autofocus
            />
          </div>
          <br />
          <div class="password">
            <label for="password" class="sr-only">Password </label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
          </div>
          <div>
            <button type="submit">Sign in</button>
          </div>
          <div>
            <router-link id="accountLink" :to="{ name: 'register' }"
              >Need an account?</router-link
            >
          </div>
          <router-link id="homeLink" v-bind:to="{ name: 'home' }"
            >Return to Home Page</router-link
          >
        </form>
      </div>
    </section>
  </html>
</template>

<script scoped>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
      isActive: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style scoped>
/* red - #F78888
yellow - #F3D250
white #ECECEC
light blue - #90CCF4
dark blue - #5DA2D5*/
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Quattrocento+Sans&display=swap");

h1 {
  text-align: center;
  font-family: "Bebas Neue", cursive;
  font-size: 2.5em;
  color: #5da2d5;
}
.sr-only {
  font-family: "Quattrocento Sans", sans-serif;
  color: #f54c4c;
}
div {
  padding: 1em;
  text-align: center;
}
button {
  font-family: "Quattrocento Sans", sans-serif;
  color: #ececec;
  background-color: #f54c4c;
  border: solid, 3px, black;
  border-radius: 12px;
  width: 20%;
  cursor: pointer;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.5);
  transition: all 0.3s ease 0s;
}
button:hover {
  background-color: #5da2d5;
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  color: #fff;
  transform: translateY(-7px);
}
#accountLink {
  font-family: "Quattrocento Sans", sans-serif;
  color: #5da2d5;
}
#homeLink {
  font-family: "Quattrocento Sans", sans-serif;
  color: #5da2d5;
}
.logo {
  width: 25%;
  height: auto;
  margin-bottom: 10px;
}
</style>
