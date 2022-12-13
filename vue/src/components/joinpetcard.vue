<template>
  <div class="info2" v-bind:class="{active: isActive}" v-on:click="isActive = !isActive">
    <div class="petCard">
      <div class="thumbnail">
        <img v-bind:src="this.pet.img" alt="the goodest boy" />
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
  data() {
      return {
          isActive: false
      }
  },
};
</script>

<style scoped>
.info2 {
    opacity: 35%;
}
.active {
    opacity: 100%;
}
.petCard {
  font-family: "Bebas Neue", cursive;
  font-size: 1.4em;
  border: 4px solid #f3d250;
  background-color: #5da2d5;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.5);
  border-radius: 32px;
  margin-top: 20px;
  width: 90%;
}
.thumbnail {
  position: relative;
  width: 300px;
  height: 300px;
  overflow: hidden;
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
.rowTwo {
  display: flex;
  text-align: center;
  justify-content: space-evenly;
  font-size: 24px;
}
</style>