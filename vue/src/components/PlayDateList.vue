<template>
  <div>
    <h1>My Scheduled Playdates</h1>
    <div class="playDate-list">
      <br />
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <playdatecard v-bind:playDate="playDate"></playdatecard>
      </div>
    </div>
  </div>
</template>

<script>
import playDateService from "../services/PlayDateService";
import playdatecard from "./ViewPlayDate.vue";

export default {
  components: {
    playdatecard,
  },
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
.playDate-list {
  display: flex;
  justify-content: center;
}
</style>