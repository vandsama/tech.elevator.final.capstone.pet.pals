<template>
  <!-- <header><img src="../../public/pet-pals-logo.png" alt="" /></header> -->
  <!-- <div class="home">
      <h1 id="home">Home</h1>
    </div> -->
  <!-- <pet-registration></pet-registration> -->
  <main>
    <div class="aboutUs">
      <h2 id="aboutTitle">My Scheduled Play Dates</h2>
      <playdateinfo></playdateinfo>
    </div>
    <pet-card-list></pet-card-list>
  </main>
</template>

<script>
import playdateinfo from "../components/PlayDateInfoList.vue";
import petCardList from "../components/PetCardList.vue";
export default {
  name: "home",
  components: { playdateinfo, petCardList },
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
  color: #f5c423;
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
