<template>
  <v-container
    fluid
    class="grey lighten-3"
  >
    <v-row>
      <v-col>
        <video-chat />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import VideoChat from "@/views/VideoChat.vue";

export default {
  name: "TwoPeople",
  components: {
    VideoChat,
  },
};
</script>

<style lang=""></style>
