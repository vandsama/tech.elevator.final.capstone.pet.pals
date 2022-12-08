<template>
  <div id="pet-registration">
    <form @submit.prevent="register">
      <div>
        <label for="name">Pet name:</label>
        <br />
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
        <br />
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
        <p>Has your pet played with other pets before?</p>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.pet_experience"
        />
        <label>Yes </label>
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.pet_experience"
        /><label>No</label>
      </section>

      <section>
        <p>Is your pet up to date on vaccinations?</p>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.vaccinated"
        /><label> Yes</label>
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.vaccinated"
        />
        <label>No</label>
      </section>

      <section>
        <p>Has your pet been spayed/neutered?</p>
        <input
          type="radio"
          class="form-control"
          value="True"
          v-model="pet.spayed"
        />
        <label>Yes</label>
        <input
          type="radio"
          class="form-control"
          value="False"
          v-model="pet.spayed"
        /><label>No</label>
      </section>
      <div>
        <label for="age">How old is your pet?</label>
        <br />
        <select id="age" class="form-control" v-model="pet.age">
          <option value="1-11 Months">1-11 Months</option>
          <option value="1-3 Years">1-3 Years</option>
          <option value="4-7 Years">4-7 Years</option>
          <option value="7-11 Years">7-11 Years</option>
          <option value="11+ Years">11+ Years</option>
        </select>
      </div>
      <section>
        <p>What is the sex of your pet?</p>
        <input
          type="radio"
          class="form-control"
          value="Male"
          v-model="pet.sex"
        /><label>Male</label>
        <input
          type="radio"
          class="form-control"
          value="Female"
          v-model="pet.sex"
        /><label>Female</label>
        <input
          type="radio"
          class="form-control"
          value="Intersex"
          v-model="pet.sex"
        /><label>Intersex</label>
      </section>
      <div>
        <label for="pet_friendliness"
          >Does your pet get along with other pets?</label
        >
        <br />
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
        <br />
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
        <p>What is your pet's favorite hobby?</p>
        <input
          type="radio"
          value="swimming"
          class="form-control"
          v-model="pet.activities"
        />
        <label for="swimming">Swimming</label>
        <input
          type="radio"
          value="walks"
          class="form-control"
          v-model="pet.activities"
        />
        <label for="walks">Walks</label>
        <input
          type="radio"
          value="fetch"
          class="form-control"
          v-model="pet.activities"
        />
        <label for="fetch">Fetch</label>
        <input
          type="radio"
          value="napping"
          class="form-control"
          v-model="pet.activities"
        />
        <label for="napping">Napping</label>
        <input
          type="radio"
          value="play hunting/wrestling"
          class="form-control"
          v-model="pet.activities"
        />
        <label for="play hunting/wrestling">Play hunting/wrestling </label>
      </section>
      <div>
        <label for="toy">Favorite Toy:</label>
        <br />
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
        <br />
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
      <br />
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
            this.$router.push({ name: 'home' });
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
p {
  font-family: "Bebas Neue", cursive;
  color: #5da2d5;
  font-size: x-large;
}
div {
  font-family: "Bebas Neue", cursive;
  color: #5da2d5;
  margin: 1em;
}
#pet-registration {
  text-align: center;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input[type="text"] {
  width: 90%;
  padding: 14px 20px;
  margin: 8px 0;
  border-radius: 4px;
  cursor: pointer;
  margin: auto;
  color: #f54c4c;
}
input[type="text"]:hover {
  background-color: #90ccf4;
}
label {
  font-size: x-large;
}
select {
  width: 100%;
  padding: 14px 20px;
  margin: 8px 0;
  border-radius: 4px;
  cursor: pointer;
}
option {
  color: #f54c4c;
}
#img {
  width: 90%;
}
select:hover {
  background-color: #90ccf4;
}
.petRegistrationBtn {
  height: 2em;
}
</style>