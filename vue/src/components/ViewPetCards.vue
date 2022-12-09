<template>
  <div class="info">
    <div class="petCard">
      <div class="thumbnail">
        <img v-bind:src="this.pet.img" alt="the goodest boy" />
      </div>
      <div class="info" id="specific">
        <div class="name">
          <h3>{{ this.pet.name }}</h3>
        </div>
        <div class="zip">
          {{ this.pet.zipCode }}
        </div>
        <div class="type">
          {{ this.pet.type }}
        </div>
        <div class="sex">
          {{ this.pet.sex }}
        </div>
        <div class="age">
          {{ this.pet.age }}
        </div>
        <div class="hobby">Loves: {{ this.pet.activities }}</div>
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
        zipCode: "",
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
#f3d250

<style>
.petCard {
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.5);
  border-radius: 32px;
  width: max-content;
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
.infoNoName {
  font-family: "Quattrocento Sans", sans-serif;
}
.info {
  background-color: #5da2d5;
  display: grid;
  margin-top: 35px;
  grid-template-columns: 0.5fr 0.5fr;
  grid-template-areas:
    "petName    zipCode"
    "type       sex"
    "activity   age";
}
.name {
  grid-area: "petName";
  font-size: 24px;
}
.type {
  grid-area: "type";
  font-family: "Quattrocento Sans", sans-serif;
}
.age {
  grid-area: "age";
  font-family: "Quattrocento Sans", sans-serif;
}
.sex {
  grid-area: "sex";
  font-family: "Quattrocento Sans", sans-serif;
}
.zip {
  grid-area: "zipCode";
  font-family: "Quattrocento Sans", sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
}
.hobby {
  grid-area: "activity";
  font-family: "Quattrocento Sans", sans-serif;
}
</style>