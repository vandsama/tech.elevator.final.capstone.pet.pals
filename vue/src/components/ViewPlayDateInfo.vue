<template>
  <div class="playdatecard">
    <div class="dateInfo">
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
h3 {
  font-family: "Bebas Neue", cursive;
  font-size: 2em;
  color: #5da2d5;
}
.dateInfo {
  font-family: "Quattrocento Sans", sans-serif;
}
.playdatecard {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #f3d250;
}
</style>