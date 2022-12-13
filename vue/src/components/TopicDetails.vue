<template>
  <div class="topic-details">
    <h1>{{ this.topic.title }}</h1>

    <div
      v-for="message in this.messages"
      v-bind:key="message.id"
      v-bind:message="message"
      class="topic-message bubble"
    >
      <message v-bind:message="message"></message>
      <!-- <h3 class="message-title">{{ message.title }}</h3> -->
      <!-- <p class="username"> {{getUsername(message.user_id)}} hi </p>
      <p class="message-body">{{ message.text }}</p> -->
      <!-- <router-link
        :to="{name: 'EditMessage', params: {topicId: $store.state.activeTopic.id, messageId: message.id} }"
        tag="button"
        class="btnEditMessage"
      >Edit</router-link>
      <button class="btnDeleteMessage" v-on:click="deleteMessage(message.id)">Delete</button> -->
    </div>

    <router-link
      :to="{
        name: 'AddMessage',
        params: { topicId: $store.state.activeTopic.id },
      }"
      class="addMessage"
      >Add New Message</router-link
    >
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

<style>
/** page structure **/
.topic-details {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
/** ios1-ios6 bubbles **/
.addMessage {
  /* display: block;
  padding: 0 0 10px 10px; */
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  text-align: left;
}
a.addMessage:link,
a.addMessage:visited {
  color: #5da2d5;
  text-decoration: none;
}
a.addMessage:hover {
  text-decoration: underline;
}

.topic-message {
  display: flex;
  justify-content: center;
  font-family: "Quattrocento Sans", sans-serif;
  text-align: left;
}
</style>