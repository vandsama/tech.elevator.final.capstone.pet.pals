<template>
  <div>
    <div v-for="pet in pets" v-bind:key="pet.id">
      <pet-card v-bind:pet="pet"></pet-card>
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
import petCards from "./ViewPetCards.vue";
export default {
  components: petService,
  petCards,
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