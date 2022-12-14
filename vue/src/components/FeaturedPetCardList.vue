<template>
  <div>
    <h1>Pets of the Week</h1>
    <div v-for="pet in pets" v-bind:key="pet.petId">
      <petCards v-bind:pet="pet"></petCards>
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
import petCards from "./ViewFeaturedPetCards.vue";
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
    petService.featured().then((r) => {
      this.pets = r.data;
    });
  },
};
</script>

<style scoped>
div {
  display: inline-block;
  background-color: #f2f2f2;
}
h1 {
  font-size: 48px;
}
</style>