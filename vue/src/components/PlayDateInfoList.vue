<template>
  <div class="playDateinfo-list">
    <div>
      <br />
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <router-link
        v-bind:to="{ name: 'playdatedetails', params: {id : playDate.playDateId}}"
        style="text-decoration: none;"
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
.playDateinfo-list {
  background-color: #f5c423;
}
</style>