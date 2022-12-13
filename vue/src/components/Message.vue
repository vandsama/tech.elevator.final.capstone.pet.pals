<template>
<div>
  <div class="message">
      <p class="username"> {{this.user.username}} says: </p>
      <!-- <p class="message-body">{{ message.text }}</p> -->
      <!-- <p class="username">{{ this.message.timestamp | formatDate }}</p> -->
      <!-- <p class="username">{{ this.message.timestamp | formatTime }}</p> -->

  </div>
  <!-- <div>
  <p class="username">{{ this.message.timestamp | formatDate }}</p>
      <p class="username">{{ this.message.timestamp | formatTime }}</p>
  </div> -->
      </div>
</template>

<script>
import userService from '../services/UserService'
export default {
props: {
    message: Object
},
data() {
    return {
        user: {}
    }
},
created() {
    userService.get(this.message.user_id).then((response) => {
        this.user = response.data
    })
}
}
</script>

<style scoped>

</style>