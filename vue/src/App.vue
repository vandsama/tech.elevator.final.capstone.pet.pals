<template>
  <div id="app">
    <!-- <div id="nav"> -->
    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    <router-link
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
      <button>Find Pets</button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'playdates' }"
          >Play Dates</router-link
        >
      </button>
      <button>
        <router-link
          style="text-decoration: none; color: white"
          v-bind:to="{ name: 'petRegistration' }"
          >Account</router-link
        >
      </button>
    </nav>
    <!-- </div> -->
    <router-view />
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
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
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
</style>

