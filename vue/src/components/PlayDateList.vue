<template>
  <div class = "playDate-list">
    <div v-for="playDate in playDates" v-bind:key="playDate.playDateId">
        {{ playDate.playDateId }}
    </div>
  </div>
</template>

<script>
import playDateService from '../services/PlayDateService'
export default {
    data() {
        return {
            playDates: []
        }
    },
    created() {
        playDateService.list().then((response) => {
        this.playDates = response.data
    })
    }
}
</script>

<style scoped>

</style>