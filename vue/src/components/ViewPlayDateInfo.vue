<template>
  <div class="playdatecard">
    <div class="dateInfo">
      <h3>
        {{ this.playDate.location }}
      </h3>
      {{ this.playDate.timestamp | formatDate }} <br />
      {{ this.playDate.timestamp | formatTime }} <br />
      <!-- {{ this.playDate.requestMessage }} <br /> -->
    </div>
  </div>
</template>

<script>
export default {
  props: {
    playDate: Object,
  },
  data() {
    return {
    };
  },
  created() {

  },
};
</script>

<style scoped>
h3 {
  font-family: "Bebas Neue", cursive;
  font-size: 2em;
  color: #5da2d5;
}
.dateInfo {
  font-family: "Quattrocento Sans", sans-serif;
  width: 40%;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.playdatecard {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #f5c423;
}
</style>