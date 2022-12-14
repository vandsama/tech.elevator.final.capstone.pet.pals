<template>
  <div class="playDateinfo-list">
    <h2 id="aboutTitle">My Scheduled Play Dates</h2>
    <div class="play">
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <router-link
          v-bind:to="{
            name: 'playdatedetails',
            params: { id: playDate.playDateId },
          }"
          style="text-decoration: none"
        >
          <playdateinfo v-bind:playDate="playDate"></playdateinfo>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import playdateinfo from "./ViewPlayDateInfo.vue";
import playDateService from "../services/PlayDateService";
export default {
  components: { playdateinfo },
  data() {
    return {
      playDates: [],
    };
  },
  created() {
    playDateService.listOwn().then((response) => {
      this.playDates = response.data;
    });
  },
};
</script>

<style scoped>
#aboutTitle {
  font-family: "Bebas Neue", cursive;
  color: white;
  font-size: 45px;
  letter-spacing: 0.05em;
}
.play {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin: auto;
}
.playDateinfo-list {
  width: 60%;
  margin: auto;
  background-color: #f5c423;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  margin-top: 2em;
}
</style>