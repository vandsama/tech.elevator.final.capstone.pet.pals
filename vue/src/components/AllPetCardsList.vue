<template>
  <div>
    <h1>Looking For A Play Date? Find your pet's new best friend below!</h1>
    <div v-for="pet in pets" v-bind:key="pet.petId">
      <petCards v-bind:pet="pet"></petCards>
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
import petCards from "./ViewAllPetCards.vue";
export default {
  components: {
    petCards,
  },
  data() {
    return {
      pets: [],
    };
  },
  created() {
    petService.list().then((r) => {
      this.pets = r.data;
    });
  },
};
</script>

<style scoped>
div {
  display: inline-block;
  margin-top: 30px;
  background-color: #f2f2f2;
}
h1 {
  font-size: 48px;
}
</style>