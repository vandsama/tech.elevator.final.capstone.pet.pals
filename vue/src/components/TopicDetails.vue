<template>
  <div>
    <h1>{{ this.topic.title }}</h1>
    <table class="message-table">
      <tbody>
        <tr
          v-for="message in this.messages"
          v-bind:key="message.id"
          v-bind:message="message" class="message-list-css"
        >
          <td>
            <message v-bind:message="message"></message>
          </td>

          <td>
            {{ message.text }}
          </td>

          <td>
            {{ message.timestamp | formatDate }}
            {{ message.timestamp | formatTime }}
          </td>
        </tr>
      </tbody>
    </table>

    <!-- <div
      v-for="message in this.messages"
      v-bind:key="message.id"
      v-bind:message="message"
      class="topic-message bubble"
    >
      <message v-bind:message="message"></message> -->

    <!-- <h3 class="message-title">{{ message.title }}</h3> -->
    <!-- <p class="username"> {{getUsername(message.user_id)}} hi </p>
      <p class="message-body">{{ message.text }}</p> -->
    <!-- <router-link
        :to="{name: 'EditMessage', params: {topicId: $store.state.activeTopic.id, messageId: message.id} }"
        tag="button"
        class="btnEditMessage"
      >Edit</router-link>
      <button class="btnDeleteMessage" v-on:click="deleteMessage(message.id)">Delete</button> -->

    <!-- </div> -->

    <div class="create-new-message">
      <router-link
        :to="{
          name: 'AddMessage',
          params: { topicId: $store.state.activeTopic.id },
        }"
        class="addMessage"
        >Post New Message</router-link
      >
    </div>
  </div>
</template>

<script>
import topicService from "@/services/TopicService.js";
import messageService from "@/services/MessageService.js";
import Message from "./Message.vue";
export default {
  components: { Message },
  name: "topic-details",
  props: {
    topicId: Number,
  },
  methods: {
    deleteMessage(id) {
      messageService.delete(id).then((response) => {
        if (response.status === 200) {
          this.$store.commit("DELETE_MESSAGE", id);
        }
      });
    },
  },
  created() {
    topicService.get(this.topicId).then((response) => {
      this.topic = response.data;
    });
    messageService
      .get(this.topicId)
      .then((response) => {
        this.messages = response.data;
      })
      .catch((error) => {
        if (error.response.status === 404) {
          this.$router.push("/not-found");
        }
      });
  },
  data() {
    return {
      messages: [],
      topic: {},
    };
  },
};
</script>

<style scoped>
.message-table {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  color: white;
  text-align: left;
  border-collapse: separate;
  border-spacing: 0 15px;
}

.message-list-css {
  font-size: large;
  font-style: italic;
  background-color: #5da2d5;
  /* border-radius: 12px; */
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  text-align: left;
  text-decoration: none;
  padding: 20px;
}

tr, td {
  padding-right: 25px;
}
a {
  color: white;
  text-decoration: none;
}
a:hover {
  color: tomato;
}
.create-new-message {
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
.create-new-message:hover {
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

</style>