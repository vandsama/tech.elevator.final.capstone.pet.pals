<template>
  <div class="joinpage">
    <h1>Select your pets attending this playdate:</h1>
    <div class="cards">
      <div
        class="card"
        v-bind:pet="pet"
        v-for="pet in pets"
        v-bind:key="pet.id"
        v-on:click="setId(pet.id)"
      >
        <joinpetcard
          class="test"
          v-bind:pet="pet"
          v-bind:key="pet.id"
        ></joinpetcard>
      </div>
    </div>
    <h3>
      Pets selected:
      <span v-for="name in petnames" v-bind:key="name">{{ name }}</span>
    </h3>
    <button v-on:click="submit">Submit</button>
  </div>
</template>

<script>
import userService from "../services/UserService";
import joinpetcard from "../components/joinpetcard.vue";
import playDateService from "../services/PlayDateService";
export default {
  components: { joinpetcard },
  data() {
    return {
      pets: [],
      petnames: [],
      petIds: [],
    };
  },
  created() {
    userService.getMyPetsNotAttending(this.$route.params.id).then((response) => {
      this.pets = response.data;
    });
  },
  methods: {
    setId(id) {
      console.log(id)
      if (this.petIds.length == 0) {this.petIds.push(id)}
      else {
      for (let i = 0; i < this.petIds.length; i++) {
        if (this.petIds[i] == id) {this.petIds.splice(i,1); console.log("test1"); break}
        else{ if (i == this.petIds.length -1) {console.log("test2"); this.petIds.push(id); break}}

      }
      }
    },
    submit() {
      playDateService.addPets(this.$route.params.id, this.petIds);
      this.$router.push(`/playdates/${this.$route.params.id}`);
    },
  },
};
</script>

<style scoped>
.joinpage {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.cards {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
.card {
  width: fit-content;
}
</style>