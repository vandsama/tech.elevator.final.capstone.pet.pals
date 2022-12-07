<template>
  <div id="app">
    <!-- <div id="nav"> -->
    <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
    <!-- <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      > -->
    <header>
      <img class="logo" src="../public/pet-pals-logo.png" alt="Pet Pals Logo" />
    </header>
    <nav>
      <button v-if="isActive">Home</button>
      <button v-if="isActive">Find Pets</button>
      <button v-if="isActive">Play Dates</button>
      <button v-if="isActive">Account</button>
    </nav>
    <!-- </div> -->
    <router-view />
  </div>
</template>
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
  justify-content: space-evenly;
}
</style>

