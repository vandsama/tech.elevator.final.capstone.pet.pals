<template>
  <div class="outline">
    <h1>Available Playdates</h1>
    <button>
      <router-link
        style="text-decoration: none; color: white"
        v-bind:to="{ name: 'schedule' }"
        >Schedule a Play Date</router-link
      >
    </button>
    <div class="playDate-list">
      <br />
      <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        <router-link
          v-bind:to="{
            name: 'playdatedetails',
            params: { id: playDate.playDateId },
          }"
          style="text-decoration: none"
        >
          <playdatecard
            v-show="playDate.cancelled == false"
            v-bind:playDate="playDate"
          ></playdatecard>
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
.outline {
  background-color: #f2f2f2;
}
button:hover {
  color: #f3d250;
}
</style>