<template>
  <v-container>
    <div>
      <input v-model="roomId" placeholder="Enter room id" />
      <button @click="toggleRoom">
        {{ hasJoined ? "Leave Room" : "Join Room" }}
      </button>
      <!-- <button @click="screenShare" v-if="hasJoined">Screen Share</button> -->
    </div>

    <div>
      <vue-webrtc
        width="100%"
        :roomId="roomId"
        ref="webrtc"
        :cameraHeight="cameraHeight"
      />
    </div>
  </v-container>
</template>

<script>
export default {
  name: "VideoChat",
  data() {
    return {
      roomId: "roomId",
      hasJoined: false,
      userid: "",
      muted: true,
      cameraHeight: 300,
    };
  },

  mounted() {},
  methods: {
    toggleRoom() {
      this.muted = true;

      if (this.hasJoined) {
        this.$refs.webrtc.leave();
        this.hasJoined = false;
      } else {
        this.$refs.webrtc.join();
        console.log(this.$refs);
        this.hasJoined = true;
        console.log("webrtc", this.$refs.webrtc.$props.cameraHeight);
        console.log("roomId : ", this.roomId);
      }
    },
    screenShare() {
      this.$refs.webrtc.shareScreen();
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
