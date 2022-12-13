<template>
  <div class="background">
    <h1>Threads</h1>
    <table class="forum-table">
      <tbody>
        <tr
          v-for="topic in this.$store.state.topics"
          v-bind:key="topic.id"
          class="topic-list-css"
        >
          <td>
            <router-link
              v-bind:to="{ name: 'Messages', params: { id: topic.id } }"
              >{{ topic.title }}</router-link
            >
          </td>
          <td>
            {{ topic.timestamp | formatDate }}
            {{ topic.timestamp | formatTime }}
          </td>
        </tr>
      </tbody>
    </table>

    <div class="create-new-topic">
      <router-link
        :to="{
          name: 'AddTopic',
          params: { topicId: $store.state.activeTopic.id },
        }"
        class="addTopic"
        >Create New Thread</router-link
      >
    </div>
  </div>
</template>

<script>
import forumsService from "../services/ForumsService.js";

export default {
  name: "topic-list",
  methods: {
    getTopics() {
      forumsService.list().then((response) => {
        this.$store.commit("SET_TOPICS", response.data);
      });
    },
    deleteTopic(id) {
      forumsService.delete(id).then((response) => {
        if (response.status == 200) {
          this.getTopics();
        }
      });
    },
  },
  created() {
    this.getTopics();
  },
};
</script>

<style scoped>
.forum-table {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  color: white;
  text-align: left;
  border-collapse: separate;
  border-spacing: 0 15px;
}
.topic-list-css {
  font-size: x-large;
  font-style: italic;
  justify-content: center;
  align-content: center;
  margin: auto;
  padding: 20px;
  background-color: #5da2d5;
  width: 60%;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  text-align: center;
  text-decoration: none;
}
td {
  padding: 3%;
}
tr {
  row-gap: 10px;
}
.topic-list-css:hover {
  transform: translateY(-7px);
  transition: all 0.3s ease 0s;
}
a {
  color: white;
  text-decoration: none;
}
a:hover {
  color: tomato;
}
.create-new-topic {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  background-color: #f5c423;
  width: 20%;
  margin: auto;
  margin-top: 3%;
  margin-bottom: 2%;
  border-radius: 15px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
}
.create-new-topic:hover {
  background-color: #5da2d5;
  box-shadow: 0px 15px 20px #69dcf0;
  transform: translateY(-7px);
  border-radius: 12px;
  transition: all 0.3s ease 0s;
}
input[type="text"] {
  border-radius: 5px;
  box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.5);
  width: 60%;
}
input[type="text"]:hover {
  transform: translateY(-5px);
  transition: all 0.3s ease 0s;
}
.background {
  background-color: #f2f2f2;
}
</style>