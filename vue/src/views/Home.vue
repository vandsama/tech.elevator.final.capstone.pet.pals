<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <pet-registration></pet-registration>
  </div>
</template>

<script>
import petRegistration from "../components/RegisterPet.vue";
export default {
  name: "home",
  components: { petRegistration },
};
</script>
