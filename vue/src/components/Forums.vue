<template>
  <div class="forums">
    <h1>Topics</h1>
    <table class="forum-table">
      <tbody>
        <tr v-for="topic in this.$store.state.topics" v-bind:key="topic.id" >
          <td width="80%" class="topic-list-css">
            <router-link 
              v-bind:to="{ name: 'Messages', params: { id: topic.id } }"
            >{{ topic.title }}</router-link>
          </td>
          <!-- <td>
            <router-link :to="{ name: 'EditTopic', params: {id: topic.id} }">Edit</router-link>
          </td>
          <td>
            <a href="#" v-on:click="deleteTopic(topic.id)">Delete</a>
          </td> -->
        </tr>
      </tbody>
    </table>

    <br>
    <br>
    <div class="create-new-topic">
      <router-link
        :to="{ name: 'AddTopic', params: {topicId: $store.state.activeTopic.id} }"
        class="addTopic"
      >Create New Thread</router-link>
    </div>

  </div>
</template>

<script>
import forumsService from "../services/ForumsService.js";

export default {
  name: "topic-list",
  methods: {
    getTopics() {
      forumsService.list().then(response => {
        this.$store.commit("SET_TOPICS", response.data);
      });
    },
    deleteTopic(id) {
      forumsService.delete(id).then(response => {
          if (response.status == 200) {
            this.getTopics();
          }
        });
    }
  },
  created() {
    this.getTopics();
  }
};
</script>

<style scoped>
.forum-table {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  text-align: left;
}

.create-new-topic {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
}


.topic-list-css {
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;
  flex-basis: flex;
  justify-content: space-around;
  background: #5da2d5;
  background-image: -webkit-gradient(
    linear,
    left bottom,
    left top,
    color-stop(0.15, #bee2ff),
    color-stop(1, #5da2d5)
  );
  background-image: -webkit-linear-gradient(bottom, #bee2ff 15%, #5da2d5 100%);
  background-image: -moz-linear-gradient(bottom, #bee2ff 15%, #5da2d5 100%);
  background-image: -ms-linear-gradient(bottom, #bee2ff 15%, #5da2d5 100%);
  background-image: -o-linear-gradient(bottom, #bee2ff 15%, #5da2d5 100%);
  background-image: linear-gradient(to top, #bee2ff 15%, #5da2d5 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#5da2d5', endColorstr='#bee2ff');
  border: solid 1px rgba(0, 0, 0, 0.5);
  -webkit-border-radius: 20px;
  -moz-border-radius: 20px;
  border-radius: 20px;
  -webkit-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  padding: 6px 20px;
  color: #000;
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
}
</style>