<template>
  <div>
    <div v-for="pet in pets" v-bind:key="pet.id">
      <petcards v-bind:pet="pet"></petcards>
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
import petcards from "./ViewPetCards.vue";
export default {
  components: {
    petcards,
  },
  data() {
    return {
      pets: [],
    };
  },
  created() {
    petService.list().then((r) => {
      this.pet = r.data;
    });
  },
};
</script>

<style scoped>
</style>