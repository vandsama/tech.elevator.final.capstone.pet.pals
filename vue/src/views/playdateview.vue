<template>
  <div class="playdate-full-details">
      <h1> {{playDate.location}} </h1>
      <h3> {{playDate.timestamp | formatDate}},  {{playDate.timestamp | formatTime}} </h3>
      <p> {{playDate.requestMessage}} </p>
      <p> Users attending: {{users.length}} </p>
      <div class="user-info" v-for="user in users" v-bind:key="user.id">
        {{user.username}} is attending with:
        <div class="user-pets" v-for="pet in user.pets" v-bind:key="pet.id">
          {{pet.name}}
        </div>
      </div>
  </div>
</template>

<script>
  import playDateService from '../services/PlayDateService'
export default {
  data() {
    return {
      playDate: {},
      users: [],
    }
  },
  created() {
    playDateService.get(this.$route.params.id).then((response) => {
      this.playDate = response.data
    })
    playDateService.listPlaydateUsers(this.$route.params.id).then((response) => {
      this.users = response.data
    })
  },
}
</script>

<style scoped>

</style>