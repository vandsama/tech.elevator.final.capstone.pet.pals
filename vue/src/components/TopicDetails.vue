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
      :to="{ name: 'AddMessage', params: {topicId: $store.state.activeTopic.id} }"
      class="addMessage"
    >Add New Message</router-link>

  </div>
</template>

<script>
import topicService from "@/services/TopicService.js";
import messageService from "@/services/MessageService.js";
import Message from './Message.vue';
export default {
  components: { Message },
  name: "topic-details",
  props: {
    topicId: Number,
  },
  methods: {
    deleteMessage(id) {
        messageService
      .delete(id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit("DELETE_MESSAGE", id);
        }
      });
    }
  },
  created() {
    topicService.get(this.topicId).then((response) => {
      this.topic = response.data
    })
    messageService
      .get(this.topicId)
      .then(response => {
        this.messages = response.data;
      })
      .catch(error => {
        if (error.response.status === 404) {
          this.$router.push("/not-found");
        }
      });
  },
  data() {
    return {
      messages: [],
      topic: {}
    }
  }
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
.topic-details .bubble {
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;
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