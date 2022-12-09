<template>
  <div class="playdatecard">
    <div class="images">
      <br />
      <h3>
        {{ this.inviteePet.name }}
        & {{ this.inviterPet.name }}
      </h3>
      {{ this.playDate.location }} <br />
      {{ this.playDate.timestamp | formatDate }} <br />
      {{ this.playDate.timestamp | formatTime }} <br />
      <!-- {{ this.playDate.requestMessage }} <br /> -->
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
export default {
  props: {
    playDate: Object,
  },
  data() {
    return {
      inviterPet: {
        name: "",
        img: "",
      },
      inviteePet: {
        name: "",
        img: "",
      },
    };
  },
  created() {
    petService.get(this.playDate.inviterPetId).then((response) => {
      this.inviterPet = response.data;
    });
    petService.get(this.playDate.inviteePetId).then((response) => {
      this.inviteePet = response.data;
    });
  },
};
</script>

<style scoped>
</style>