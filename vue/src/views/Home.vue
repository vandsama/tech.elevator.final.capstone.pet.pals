<template>
  <div>
    <!-- <header><img src="../../public/pet-pals-logo.png" alt="" /></header> -->
    <!-- <div class="home">
      <h1 id="home">Home</h1>
    </div> -->
    <!-- <pet-registration></pet-registration> -->
    <main>
      <div class="aboutUs">
        <h2 id="aboutTitle">What We're All About</h2>
        <p id="aboutDesc">
          Our mission is to connect pets and their owners across the Cincinnati
          area in order to form smaller communities and allow people and pets to
          meet new friends! Many different kinds of animals, from dogs to cats
          to bearded dragons, benefit from social interaction with other pets.
          Connect with other pet owners by meeting at a pet park or pet-friendly
          area, and make a new friend today.
        </p>
      </div>
      <pet-cards></pet-cards>
    </main>
  </div>
</template>

<script>
import petCards from "../components/ViewPetCards.vue";
export default {
  name: "home",
  components: { petCards },
};
</script>
<style scoped>
div {
  background-color: white;
}
button {
  display: inline-block;
  margin: 1 em;
  height: 2em;
  border: none;
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
}
#aboutTitle {
  font-family: "Bebas Neue", cursive;

  color: white;
  font-size: 45px;
  letter-spacing: 0.05em;
}
#aboutDesc {
  font-family: "Quattrocento Sans", sans-serif;
  color: white;
  font-size: x-large;
  font-style: italic;
  width: 80%;
  margin: auto;
  padding-bottom: 5%;
}
.aboutUs {
  width: 60%;
  margin: auto;
  background-color: #f5c423;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  margin-top: 2em;
}
/* header {
  display: flex;
  align-content: flex-start;
} */
/* header > img {
  width: 30%;
  height: auto;
} */
</style>
