<template>
  <h1>Logout</h1>
</template>

<script scoped>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  },
};
</script>
