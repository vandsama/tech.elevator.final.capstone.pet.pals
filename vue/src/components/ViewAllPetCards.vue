<template>
  <div class="petCard">
    <div class="thumbnail">
      <img v-bind:src="this.pet.img" alt="the goodest boy" />
    </div>
    <div class="nameZip">
      <h2>
        {{ this.pet.name }}
      </h2>
      <h5>
        {{ this.pet.zipCode }}
      </h5>
    </div>
    <div class="basicInfo">
      {{ this.pet.type }}, {{ this.pet.sex }},
      {{ this.pet.age }}
    </div>
    <div class="healthInfo">
      <span>Is your pet spayed/neutered? &nbsp;</span>
      {{ this.pet.spayed }}
      <br />
      <span>Is your pet vaccinated? &nbsp;</span>
      {{ this.pet.vaccinated }}
      <br />
      <span>Has your pet played with other pets before? &nbsp;</span>
      {{ this.pet.pet_experience }}
    </div>
    <div class="friendliness">
      <span>Is your pet friendly to other pets?</span>
      <br />
      {{ this.pet.pet_friendliness }}
      <br />
      <span>Is your pet friendly to humans?</span>
      <br />
      {{ this.pet.human_friendliness }}
    </div>
    <div class="favorites">
      <p>Loves:</p>
      {{ this.pet.activities }}, {{ this.pet.toy }},
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
  font-size: 1.4em;
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.5);
  border-radius: 32px;
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  width: auto;
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
button:hover {
  background-color: #f3d250;
}
button {
  width: 20%;
}
.nameZip {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.healthInfo,
.friendliness {
  font-family: "Quattrocento Sans", sans-serif;
  text-align: left;
}
span {
  font-family: "Bebas Neue", cursive;
}
.favorites {
  text-align: left;
}
.basicInfo {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
/* li {
  list-style-type: none;
  display: inline;
} */
</style>