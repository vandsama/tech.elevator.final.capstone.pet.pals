<template>
  <!-- <header><img src="../../public/pet-pals-logo.png" alt="" /></header> -->
  <!-- <div class="home">
      <h1 id="home">Home</h1>
    </div> -->
  <!-- <pet-registration></pet-registration> -->
  <main>
    <playdateinfo></playdateinfo>
    <pet-card-list></pet-card-list>
  </main>
</template>

<script>
import playdateinfo from "../components/PlayDateInfoList.vue";
import petCardList from "../components/FeaturedPetCardList.vue";
export default {
  name: "home",
  components: { playdateinfo, petCardList },
};
</script>
<style scoped>
button {
  display: inline-block;
  margin: 1 em;
  height: 2em;
  border: none;
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
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
