<template>
  <form v-on:submit.prevent>
    <!-- <div class="field">
      <label for="title">Title</label>
      <input type="text" name="title" v-model="message.title" />
    </div> -->
    <div class="field">
      <!-- <label for="messageText">Message</label> -->
      <input type="text" name="messageText" v-model="message.text" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="saveMessage()">Save Message</button>
    </div>
  </form>
</template>

<script>
import messageService from "../services/MessageService";

export default {
  name: "create-message",
  props: {
    topicId: Number
  },
  data() {
    return {
      message: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        topicId: this.topicId,
        title: "",
        text: ""
      }
    };
  },
  methods: {
    
    saveMessage() {
      
      messageService.create(this.message.topicId, this.message)
                    .then((response) => {
                      if(response.status === 201) {
                        this.$router.push(`/forums/${this.message.topicId}`)
                      }
                    })
    }
  }
};
</script>

<style>
</style>