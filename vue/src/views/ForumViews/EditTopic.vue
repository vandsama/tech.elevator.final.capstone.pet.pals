<template>
  <div>
    <h1>Edit Topic</h1>
    <update-topic v-bind:topicID="parseInt($route.params.id)" />
  </div>
</template>

<script>
import UpdateTopic from "../../components/ForumComponents/UpdateTopic";

export default {
  components: {
    UpdateTopic
  }
};
</script>

<style>
</style>
