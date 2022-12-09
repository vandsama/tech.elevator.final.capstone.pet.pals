<template>
  <div class="playDate-list">
    <div>
      <br />
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <playdateinfo v-bind:playDate="playDate"></playdateinfo>
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
    playDateService.list().then((response) => {
      this.playDates = response.data;
    });
  },
};
</script>

<style scoped>
.playDate-list {
  background-color: #f5c423;
}
</style>