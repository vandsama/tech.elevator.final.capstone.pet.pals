<template>
  <div>
    <h1>Upcoming Playdates</h1>
    <div class="playDate-list">
      <br />
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <router-link
        v-bind:to="{ name: 'playdatedetails', params: {id : playDate.playDateId}}"
        style="text-decoration: none;"
        >
        <playdatecard v-bind:playDate="playDate"></playdatecard>
        </router-link>
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
    playDateService.list().then((response) => {
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