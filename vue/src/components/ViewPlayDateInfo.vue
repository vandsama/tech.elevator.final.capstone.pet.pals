<template>
  <div class="playdatecard">
    <div class="dateInfo">
      <div class="location">
        <h3>
          <font-awesome-icon icon="fa-solid fa-map-pin" color="red" size="xs" />
          &nbsp; {{ this.playDate.location }}
        </h3>
      </div>
      <div class="onHoverLocation">Location</div>
      <div class="date">
        <font-awesome-icon icon="fa-solid fa-calendar-days" color="black" />
        &nbsp;
        {{ this.playDate.dateAndTime | formatDate }}

        <br />
      </div>
      <div class="time">
        <font-awesome-icon icon="fa-solid fa-clock" color="black" /> &nbsp;
        {{ this.playDate.dateAndTime | formatTime }}

        <br />
        <!-- {{ this.playDate.requestMessage }} <br /> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    playDate: Object,
  },
  name: "App",
  data() {
    return {};
  },
  created() {},
};
</script>

<style scoped>
h3 {
  font-family: "Bebas Neue", cursive;
  font-size: 2.5em;
  color: #5da2d5;
}
.dateInfo {
  font-family: "Quattrocento Sans", sans-serif;
  width: 60%;
  color: #f54c4c;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  position: relative;
  height: 60%;
}
.playdatecard {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background-color: #f5c423;
}
.location {
  display: flex;
  flex-direction: row;
}
.time {
  font-size: 1.5em;
}
.date {
  font-size: 1.5em;
}
.onHoverLocation {
  display: none;
}
.location:hover + .onHoverLocation {
  display: block;
  position: absolute;
  width: 140px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 5px;
  padding: 5px 0;
  transition: opacity 10s ease-in-out;
  top: 20%;
  left: 5%;
  z-index: 1;
}
</style>