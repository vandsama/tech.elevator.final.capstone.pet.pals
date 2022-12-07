<template>
  <div>
      <h1>Test Play Date View</h1>
  </div>
</template>

<script>
import playDateService from "../services/PlayDateService";
export default {
    data() {
        return {
            playdate: {
                playDateId: 0,
                timestamp: 0,
                location: "",
                requestMessage: "",
                inviterUserId: 0,
                inviterPetId: 0,
                inviteeUserId: 0,
                inviteePetId: 0,
            }
        }
    },
    created() {
        playDateService.get(this.$route.params.playDateId).then((response) => {
            this.playdate = response.data;
        });
    },
};
</script>


<style scoped>

</style>