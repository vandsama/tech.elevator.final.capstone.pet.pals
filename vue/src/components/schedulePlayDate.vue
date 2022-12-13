<template>
  <div class="schedulePlayDates">
    <form @submit.prevent="schedule()">
      <div class="timestamp">
        <label for="timestamp">Date and Time:</label>
        <br />
        <input
          type="datetime-local"
          class="form-control"
          placeholder="Date and Time"
          v-model="playDate.dateAndTime"
          required
        />
      </div>
      <div class="location">
        <label for="location">Location:</label>
        <br />
        <input
          type="text"
          class="form-control"
          placeholder="Location"
          required
          v-model="playDate.location"
        />
      </div>
      <div class="message">
        <label for="message">Message:</label>
        <br />
        <textarea
          name="message"
          id="message"
          cols="25"
          rows="5"
          required
          v-model="playDate.requestMessage"
        ></textarea>
      </div>
      <button class="schedule" type="submit">Schedule Play Date</button>
    </form>
  </div>
</template>


<script>
import PlayDateService from "../services/PlayDateService";
export default {
  name: "schedulePlayDate",
  errorMessage: "",
  data() {
    return {
      playDate: {
        dateAndTime: "",
        location: "",
        requestMessage: "",
      },
    };
  },
  methods: {
    schedule() {
      PlayDateService.schedule(this.playDate)
        .then((r) => {
          if (r.status == 200) {
            this.$router.push({ name: "home" });
          }
        })
        .catch((error) => {
          if (error.status === 400) {
            this.errorMessage = "Could not schedule play date";
          }
        });
    },
  },
};
</script>

<style scoped>
div {
  font-family: "Quattrocento Sans", sans-serif;
  font-size: x-large;
  color: #5da2d5;
}
.schedulePlayDates {
  text-align: center;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input {
  width: 90%;
  padding: 14px 20px;
  margin: 8px 0;
  border-radius: 4px;
  cursor: pointer;
  margin: auto;
}
input:hover {
  background-color: #90ccf4;
}
textarea {
  width: 90%;
  padding: 14px 20px;
  margin: 8px 0;
  border-radius: 4px;
  cursor: pointer;
  margin: auto;
}
textarea:hover {
  background-color: #90ccf4;
}
button:hover {
  background-color: #f3d250;
}
</style>