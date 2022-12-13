<template>
  <div class="forums">
    <h1>Topics</h1>
    <table class="forum-table">
      <tbody>
        <div class="topic-list-css">
          <tr v-for="topic in this.$store.state.topics" v-bind:key="topic.id">
            <td>
              <router-link
                v-bind:to="{ name: 'Messages', params: { id: topic.id } }"
                >{{ topic.title }}</router-link
              >
            </td>
            <td class="topic-list-css">
              {{ topic.timestamp | formatDate }}
              {{ topic.timestamp | formatTime }}
            </td>
            <!-- <td>
            <router-link :to="{ name: 'EditTopic', params: {id: topic.id} }">Edit</router-link>
          </td>
          <td>
            <a href="#" v-on:click="deleteTopic(topic.id)">Delete</a>
          </td> -->
          </tr>
        </div>
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
}

.create-new-topic {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
}

.topic-list {
  font-size: large;
  font-style: italic;
  margin: auto;
  background-color: #5da2d5;
  width: 60%;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  margin-bottom: 5%;
}
.topic-list-css {
  font-size: x-large;
  font-style: italic;
  margin: auto;
  padding-top: 2%;
  padding-bottom: 2%;
  padding-right: 5%;
  padding-left: 5%;
  background-color: #5da2d5;
  width: 60%;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  text-align: center;
  text-decoration: none;
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
tr {
  row-gap: 10px;
}
</style>