<template>
  <div class="playdatecard">
    <h3>
      {{ this.playDate.location }}
    </h3>
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
  methods: {
    PetImgPortrait(src) {
      let img = new Image();
      img.src = src;
      // img.onload = () => {
      if (img.height > img.width) return true;
      // }
      else return false;
    },
  },
};
</script>


<style scoped>
.images {
  display: flex;
}

.playdatecard {
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  border: 4px solid #5da2d5;
  background-color: azure;
  border-radius: 6px;
  width: max-content;
}

.thumbnail {
  position: relative;
  width: 150px;
  height: 150px;
  overflow: hidden;
  margin: 10px;
  border: 5px solid #5da2d5;
  background-color: #5da2d5;
  border-radius: 5px;
}
.thumbnail img {
  position: absolute;
  left: 50%;
  top: 50%;
  height: 200px;
  width: auto;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.thumbnail img.portrait {
  width: 100%;
  height: auto;
}
</style>