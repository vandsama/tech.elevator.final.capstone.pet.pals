<template>
  <section>
    <img
      class="logo"
      src="../../public/pet-pals-logo.png"
      alt="Pet Pals Logo"
    />
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div>
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
        <div>
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
          <label for="password" class="sr-only">Confirm Password </label>
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        </div>
        <div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </button>
        </div>
        <div>
          <router-link id="haveAccLink" :to="{ name: 'login' }"
            >Have an account?</router-link
          >
        </div>
        <router-link id="homeLink" v-bind:to="{ name: 'home' }"
          >Return to Home Page</router-link
        >
      </form>
    </div>
  </section>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
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
#haveAccLink {
  font-family: "Quattrocento Sans", sans-serif;
  color: #5da2d5;
}
body {
  background-color: #f3d250;
  height: 55em;
  display: flex;
  flex-direction: column;
  justify-content: center;
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
