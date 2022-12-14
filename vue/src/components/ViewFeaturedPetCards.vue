<template>
  <div class="info2">
    <div class="petCard">
      <div class="thumbnail">
        <img id="pet" v-bind:src="this.pet.img" alt="the goodest boy" />
      </div>
      <div class="info" id="specific">
        <div class="firstRow">
          <div class="name">
            {{ this.pet.name }}
          </div>
          <div class="zip">
            {{ this.pet.zipCode }}
          </div>
        </div>
        <div class="rowTwo">
          <div class="type">
            {{ this.pet.type }}
          </div>
          <div class="sex">
            {{ this.pet.sex }}
          </div>
          <div class="age">
            {{ this.pet.age }}
          </div>
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
  props: {
    pet: Object,
  },
};
</script>

<style>
.petCard {
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.5);
  border-radius: 32px;
  margin-top: 20px;
  width: 350px;
}
.thumbnail {
  position: relative;
  width: 300px;
  height: 300px;
  overflow: hidden;
  background-color: #5da2d5;
  display: flex;
  margin: auto;
}
#pet {
  position: absolute;
  left: 50%;
  top: 50%;
  height: 350px;
  width: auto;
  transform: translate(-50%, -50%);
}
.infoNoName {
  font-family: "Quattrocento Sans", sans-serif;
}
.firstRow {
  display: flex;
  justify-content: center;
}
.zip {
  display: flex;
  font-size: xx-large;
}
.name {
  font-size: xx-large;
}
/* .info {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows:
    "name   name    zip"
    "type   sex     age"
    "hobby  hobby   hobby";
} 
.name {
  font-size: 32px;
  grid-area: "name";
}
.type {
  font-family: "Quattrocento Sans", sans-serif;
  grid-area: "type";
}
.age {
  font-family: "Quattrocento Sans", sans-serif;
  grid-area: "age";
}
.sex {
  font-family: "Quattrocento Sans", sans-serif;
  grid-area: "sex";
}
.zip {
  font-family: "Quattrocento Sans", sans-serif;
  grid-area: "zip";
}
.hobby {
  grid-area: "activity";
  font-family: "Quattrocento Sans", sans-serif;
  grid-area: "hobby";
  font-size: 24px;
}*/
.rowTwo {
  display: flex;
  text-align: center;
  justify-content: space-evenly;
  font-size: 24px;
}
</style>