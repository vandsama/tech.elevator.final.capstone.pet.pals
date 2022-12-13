<template>
  <div class="playdatecard">
    <h3>
      <font-awesome-icon icon="fa-solid fa-map-pin" color="red" size="xs" />
      &nbsp;
      {{ this.playDate.location }}
    </h3>
    <font-awesome-icon
      icon="fa-solid fa-calendar-days"
      color="black"
      size="xs"
    />
    &nbsp;{{ this.playDate.dateAndTime | formatDate }} <br />
    <font-awesome-icon icon="fa-solid fa-clock" color="black" size="xs" />
    &nbsp; {{ this.playDate.dateAndTime | formatTime }} <br />
    {{ this.playDate.requestMessage }} <br />
  </div>
</template>

<script>
// import petService from "../services/PetService";
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
    // petService.get(this.playDate.inviterPetId).then((response) => {
    //   this.inviterPet = response.data;
    // });
    // petService.get(this.playDate.inviteePetId).then((response) => {
    //   this.inviteePet = response.data;
    // });
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
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  border-radius: 6px;
  width: max-content;
  box-shadow: 0px 10px 16px rgba(0, 0, 0, 0.5);
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
div {
  color: azure;
}
h3 {
  letter-spacing: 1px;
}
</style>