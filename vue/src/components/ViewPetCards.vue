<template>
  <div class="petCard">
    <div class="thumbnail">
      <img v-bind:src="this.pet.img" alt="the goodest boy" />
    </div>
    <div class="info">
      <h3>{{ this.pet.name }}</h3>
      <div class="infoNoName">
        {{ this.pet.type }} <br />
        {{ this.pet.age }} <br />
        {{ this.pet.sex }} <br />
        {{ this.pet.activities }}
      </div>
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
    // petService.get(3).then((r) => {
    //   this.pet = r.data;
    // });
  },
};
</script>

<style>
.petCard {
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
.infoNoName {
  font-family: "Quattrocento Sans", sans-serif;
}
</style>