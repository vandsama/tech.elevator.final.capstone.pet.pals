<template>
  <div id="pet-registration">
    <form @submit.prevent="register">
      <div>
        <label for="name">Pet name:</label>
        <input
          type="text"
          id="name"
          class="form-control"
          placeholder="Pet Name"
          v-model="pet.name"
          required
        />
      </div>
      <div>
        <label for="type">Type of animal:</label>
        <input
          type="text"
          id="type"
          class="form-control"
          placeholder="Animal type"
          v-model="pet.type"
          required
        />
      </div>
      <section>
        <h3>Has your pet played with other pets before?</h3>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.pet_experience"
        />Yes
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.pet_experience"
        />No
      </section>

      <section>
        <h3>Is your pet up to date on vaccinations?</h3>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.vaccinated"
        />Yes
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.vaccinated"
        />No
      </section>

      <section>
        <h3>Has your pet been spayed/neutered?</h3>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.spayed"
        />Yes
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.spayed"
        />No
      </section>
      <div>
        <label for="age">How old is your pet?</label>
        <select id="pet_friendliness" class="form-control" v-model="pet.age">
          <option value="1-11 Months">1-11 Months</option>
          <option value="1-3 Years">1-3 Years</option>
          <option value="4-7 Years">4-7 Years</option>
          <option value="7-11 Years">7-11 Years</option>
          <option value="11+ Years">11+ Years</option>
        </select>
      </div>
      <section>
        <h3>What is the sex of your pet?</h3>
        <input
          type="radio"
          class="form-control"
          value="Male"
          v-model="pet.sex"
        />Male
        <input
          type="radio"
          class="form-control"
          value="Female"
          v-model="pet.sex"
        />Female
        <input
          type="radio"
          class="form-control"
          value="Intersex"
          v-model="pet.sex"
        />Intersex
      </section>
      <div>
        <label for="pet_friendliness"
          >Does your pet get along with other pets?</label
        >
        <select
          id="pet_friendliness"
          class="form-control"
          v-model="pet.pet_friendliness"
        >
          <option value="Yes">Yes</option>
          <option value="No">No</option>
          <option value="Takes some warming up to">
            Takes some warming up to
          </option>
        </select>
      </div>
      <div>
        <label for="human_friendliness"
          >Does your pet get along with people?</label
        >
        <select
          id="human_friendliness"
          class="form-control"
          v-model="pet.human_friendliness"
        >
          <option value="Yes">Yes</option>
          <option value="No">No</option>
          <option value="Takes some warming up to">
            Takes some warming up to
          </option>
        </select>
      </div>
      <section required>
        <h3></h3>
        <input
          type="checkbox"
          id="swimming"
          class="form-control"
          v-bind="pet.activities"
        />
        <label for="swimming">Swimming</label>
        <input
          type="checkbox"
          id="walks"
          class="form-control"
          v-bind="pet.activities"
        />
        <label for="walks">Walks</label>
        <input
          type="checkbox"
          id="fetch"
          class="form-control"
          v-bind="pet.activities"
        />
        <label for="fetch">Fetch</label>
        <input
          type="checkbox"
          id="napping"
          class="form-control"
          v-bind="pet.activities"
        />
        <label for="napping">Napping</label>
        <input
          type="checkbox"
          id="play hunting/wrestling"
          class="form-control"
          v-bind="pet.activities"
        />
        <label for="play hunting/wrestling">Play hunting/wrestling </label>
        <label for="other">Other: </label>
        <input
          type="text"
          id="other"
          class="form-control"
          v-bind="pet.activities"
        />
      </section>
      <div>
        <label for="toy">Favorite Toy:</label>
        <input
          type="text"
          id="toy"
          class="form-control"
          placeholder="Toy"
          v-model="pet.toy"
          required
        />
      </div>
      <div>
        <label for="treat">Favorite Treat:</label>
        <input
          type="text"
          id="treat"
          class="form-control"
          placeholder="Treat"
          v-model="pet.treat"
          required
        />
      </div>
      <!-- TODO change from link??? -->
      <label for="img"
        >Please include a Google Drive link to a picture of your pet.</label
      >
      <input
        type="text"
        id="img"
        class="form-control"
        placeholder="Google Drive Link"
        v-model="pet.img"
        required
      />
      <div>
        <button class="petRegistrationBtn" type="submit">Register Pet</button>
      </div>
    </form>
  </div>
</template>

<script>
import petService from "../services/PetService";
export default {
  name: "petRegistration",
  registrationErrorMessage: "",
  data() {
    return {
      pet: {
        type: "",
        name: "",
        pet_experience: "",
        vaccinated: "",
        spayed: "",
        age: "",
        sex: "",
        pet_friendliness: "",
        human_friendliness: "",
        activities: "",
        toy: "",
        treat: "",
        img: "",
      },
    };
  },
  methods: {
    register() {
      petService
        .register(this.pet)
        .then((response) => {
          if (response.status == 201) {
            //   this.$router.push({
            //       path: '/',
            //   })
          }
        })
        .catch((error) => {
          if (error.status === 400) {
            this.registrationErrorMessage = "Could not register pet";
          }
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Quattrocento+Sans&display=swap");
.form-control {
  font-family: "Quattrocento Sans", sans-serif;
}
h3 {
  font-family: "Bebas Neue", cursive;
  color: #5da2d5;
}
div {
  font-family: "Quattrocento Sans", sans-serif;
  color: #f54c4c;
  margin: 1em;
}
#pet-registration {
  text-align: center;
}
</style>