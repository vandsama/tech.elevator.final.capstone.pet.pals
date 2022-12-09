<template>
  <div>
    <main>
      <div id="aboutUs1">
        <h2>What We're All About</h2>
        <p id="aboutDesc">
          Our mission is to connect pets and their owners across the Cincinnati
          area in order to form smaller communities and allow people and pets to
          meet new friends! Many different kinds of animals, from dogs to cats
          to bearded dragons, benefit from social interaction with other pets.
          Connect with other pet owners by meeting at a pet park or pet-friendly
          area, and make a new friend today.
        </p>
      </div>
      <div id="contactUs">
        <h2>Contact Us</h2>
        <div class="container">
          <form action="action_page.php">
            <label for="fname">First Name</label>
            <input
              type="text"
              id="fname"
              name="firstname"
              placeholder="Your name.."
            />

            <label for="lname">Last Name</label>
            <input
              type="text"
              id="lname"
              name="lastname"
              placeholder="Your last name.."
            />

            <label for="country">Country</label>
            <select id="country" name="country">
              <option value="australia">Australia</option>
              <option value="canada">Canada</option>
              <option value="usa">USA</option>
            </select>

            <label for="subject">Subject</label>
            <textarea
              id="subject"
              name="subject"
              placeholder="Write something.."
              style="height: 200px"
            ></textarea>

            <input type="submit" value="Submit" />
          </form>
        </div>
      </div>
    </main>
  </div>
</template>
<style>
#aboutUs1 {
  width: 60%;
  margin: auto;
  background-color: #f5c423;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  margin-top: 2em;
}
#contactUs {
  width: 60%;
  margin: auto;
  background-color: #f5c423;
  border-radius: 12px;
  box-shadow: 0px 20px 30px rgba(0, 0, 0, 0.5);
  margin-top: 2em;
}
h2 {
  font-family: "Bebas Neue", cursive;
  color: white;
  font-size: 45px;
  letter-spacing: 0.05em;
}
#aboutDesc {
  font-family: "Quattrocento Sans", sans-serif;
  color: white;
  font-size: x-large;
  font-style: italic;
  width: 80%;
  margin: auto;
  padding-bottom: 5%;
}
input[type="text"],
select,
textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical; /* Allow the user to vertically resize the textarea (not horizontally) */
  font-family: "Quattrocento Sans", sans-serif;
}

/* Style the submit button with a specific background color etc */
input[type="submit"] {
  background-color: #f5c423;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type="submit"]:hover {
  background-color: #5da2d5;
  box-shadow: 0px 15px 20px #69dcf0;
  color: white;
  transform: translateY(-7px);
}

/* Add a background color and some padding around the form */
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
label {
  font-family: "Quattrocento Sans", sans-serif;
}
</style>