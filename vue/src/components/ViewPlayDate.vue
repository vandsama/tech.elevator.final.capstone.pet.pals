<template>
  <div class="playdatecard">
    <img v-bind:src="this.inviteePet.img" />
    <img v-bind:src="this.inviterPet.img" /> <br />
    <h3>{{this.inviteePet.name}} & {{this.inviterPet.name}}</h3>
    {{ this.playDate.location }} <br />
    {{ this.playDate.timestamp | formatDate }} <br />
    {{ this.playDate.timestamp | formatTime }} <br />
    {{ this.playDate.requestMessage }} <br />
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
.playdatecard {
    border: 4px solid #5da2d5;
    background-color: azure;
    border-radius: 6px;
    width: max-content;
}

img {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 150px;
}
</style>