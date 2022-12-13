<template>
  <div class="outer">
    <br />
    <div class="playdate-full-details">
      <h1>{{ playDate.location }}</h1>
      <h3>
        {{ playDate.dateAndTime | formatDate }},
        {{ playDate.dateAndTime | formatTime }}
      </h3>
      <p>{{ playDate.requestMessage }}</p>
      <p>Pets Attending: {{ totalPets }}</p>
      <div class="userbox">
        <div class="user-info" v-for="user in users" v-bind:key="user.id">
          {{ user.username }} is attending with:
          <div class="user-pets">
            <div v-for="pet in user.pets" v-bind:key="pet.id">
              <router-link
                style="text-decoration: none; color: black"
                v-bind:to="{ name: 'ViewPets', hash: '#petCard' }"
                >{{ pet.name }}</router-link
              >
            </div>
          </div>
        </div>
      </div>
    </div>
    <br />

    <router-link
      v-bind:to="{ name: 'playdatejoin', params: { id: playDate.playDateId } }"
      style="text-decoration: none"
    >
      <button class="btn">Join this playdate!</button>
    </router-link>
  </div>
</template>

<script>
import playDateService from "../services/PlayDateService";
export default {
  data() {
    return {
      playDate: {},
      users: [],
    };
  },
  created() {
    playDateService.get(this.$route.params.id).then((response) => {
      this.playDate = response.data;
    });
    playDateService
      .listPlaydateUsers(this.$route.params.id)
      .then((response) => {
        this.users = response.data;
      });
  },
  computed: {
    totalPets() {
      let count = 0;
      this.users.forEach((user) => {
        for (let i = 0; i < user.pets.length; i++) {
          count++;
        }
      });
      return count;
    },
  },
};
</script>


<!-- could use more styling --> 
<style scoped>
h1 {
  margin: 1rem;
}
.btn {
  width: 12em;
}
.outer {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.playdate-full-details {
  display: grid;
  background-color: #d4f6ff;
  border-radius: 1rem;
  width: 50%;
  font-family: "Quattrocento Sans", sans-serif;
  font-size: 18px;
}
.user-info {
  display: flex;
  justify-content: left;
  align-items: center;
  background-color: #a6deed;
  margin: 5px;
  border-radius: 1rem;
}
.user-pets {
  display: flex;
  flex-direction: column;
  justify-content: right;
  flex-grow: 1;
  padding: 0;
  align-items: flex-end;
}
</style>