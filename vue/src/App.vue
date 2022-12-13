<template>
  <div id="app">
    <!-- <div id="nav"> -->
    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    <router-link
      style="text-decoration: none; color: #f54c4c"
      id="logout"
      v-bind:to="{ name: 'logout' }"
      v-if="$store.state.token != ''"
      >Logout</router-link
    >
    <header>
      <img class="logo" src="../public/pet-pals-logo.png" alt="Pet Pals Logo" />
    </header>
    <nav v-if="isActive">
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'home' }"
          >Home</router-link
        >
      </button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'ViewPets' }"
          >Find Pets</router-link
        >
      </button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'playDates' }"
          >Play Dates</router-link
        >
      </button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'forums' }"
          >Forums</router-link
        >
      </button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'petRegistration' }"
          >Register a Pet</router-link
        >
      </button>
    </nav>
    <!-- </div> -->
    <router-view />
    <footer v-if="isActive">
      <div>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'aboutUs', hash: '#contactUs' }"
          >contact us</router-link
        >
      </div>
      <div>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'aboutUs', hash: '#aboutUs1' }"
          >about us</router-link
        >
      </div>
      <div>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'petRegistration' }"
          >account</router-link
        >
      </div>
      <section>&copy; <span>All Rights Reserved.</span></section>
    </footer>
  </div>
</template>

<script>
export default {
  computed: {
    isActive() {
      return this.$store.state.token != "";
    },
  },
};
</script>


<style scoped>
button {
  display: inline-block;
  margin: 1em;
  width: 20%;
  height: 2em;
  border: none;
  border-radius: 12px;
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  align-items: flex-start;
  background-color: #f54c4c;
  color: white;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.5);
  transition: all 0.3s ease 0s;
}
button:hover {
  background-color: #5da2d5;
  box-shadow: 0px 15px 20px #69dcf0;
  color: #fff;
  transform: translateY(-7px);
}
header {
  text-align: center;
}
nav {
  display: flex;
  width: 65%;
  margin: auto;
}
#logout {
  display: flex;
  flex-direction: left;
  font-family: "Bebas Neue", cursive;
}
footer {
  width: 100%;
  height: 15em;
  background-color: #f54c4c;
  border-radius: 12px;
}
footer > div {
  display: inline-block;
  color: #fff;
  font-family: "Quattrocento Sans", sans-serif;
  font-size: 1.4em;
  transition: all 0.3s ease 0s;
  height: 15px;
  margin-top: 2%;
  padding-left: 8%;
  padding-right: 8%;
}
footer > section {
  color: #fff;
  margin-top: 15%;
  font-family: "Quattrocento Sans", sans-serif;
}
footer > div:hover {
  background-color: #5da2d5;
  box-shadow: 0px 15px 20px #69dcf0;
  transform: translateY(-7px);
  border-radius: 12px;
}
img {
  height: 250px;
  width: 250px;
}
</style>

