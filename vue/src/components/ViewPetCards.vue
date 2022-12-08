<template>
  <div>
    <img v-bind:src="this.pet.img" alt="the goodest boy" />
    <div class="info">
      {{ this.pet.name }}
      {{ this.pet.age }}
      {{ this.pet.type }}
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
export default {
  component: petService,
  data() {
    return {
      pet: {
        name: "",
        age: "",
        type: "",
        img: "",
        imgheight: "",
        imgwidth: "",
      },
    };
  },
  created() {
    petService.get(2).then((r) => {
      this.pet = r.data;
    });
  },
};
</script>

<style>
</style>