<template>
  <div class="petCard">
    <div class="thumbnail">
      <img v-bind:src="this.pet.img" alt="the goodest boy" />
    </div>
    <div class="nameZip">
      {{ this.pet.name }}
      {{ this.pet.zipCode }}
    </div>
    <div class="basicInfo">
      {{ this.pet.type }}
      {{ this.pet.sex }}
      {{ this.pet.age }}
    </div>
    <div class="healthInfo">
      {{ this.pet.spayed }}
      {{ this.pet.vaccinated }}
      {{ this.pet.petExperience }}
    </div>
    <div class="friendliness">
      {{ this.pet.petFriendliness }}
      {{ this.pet.humanFriendliness }}
    </div>
    <div class="favorites">
      <p>Loves:</p>
      {{ this.pet.activities }}
      {{ this.pet.toy }}
      {{ this.pet.treat }}
    </div>
    <button>Request Play Date</button>
  </div>
</template>

<script>
import petService from "../services/PetService";
export default {
  component: petService,
  props: {
    pet: Object,
  },
};
</script>

<style scoped>
.petCard {
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.5);
  border-radius: 32px;
  margin-top: 20px;
}
.thumbnail {
  position: relative;
  width: 350px;
  height: 350px;
  overflow: hidden;
  margin: 10px;
  border: 5px solid #5da2d5;
  background-color: #5da2d5;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.thumbnail img {
  position: absolute;
  left: 50%;
  top: 50%;
  height: 400px;
  width: auto;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
/* li {
  list-style-type: none;
  display: inline;
} */
</style>