<template>
  <div v-if="streamManager" align="center">
    <a style="cursor: default">
      <div class="video-area">
        <toolbar />
        <!--
        <div class="bottom">
          <div @click="toggleMic">
            <v-btn fab small dark color="grey">
              <v-icon>
                {{ this.statusMic ? "mdi-microphone" : "mdi-microphone-off" }}
              </v-icon>
            </v-btn>
          </div>
        </div> -->

        <ov-video :stream-manager="streamManager" />
      </div>
    </a>
  </div>
</template>

<script>
import OvVideo from "@/components/chat_room/OvVideo";
import Toolbar from "@/components/chat_room/Toolbar";

export default {
  name: "UserVideo",

  components: {
    OvVideo,
    Toolbar,
  },

  props: {
    streamManager: Object,
  },

  data: () => ({
    // statusMic: false,
  }),

  computed: {
    clientData() {
      const { clientData } = this.getConnectionData();
      return clientData;
    },
  },

  methods: {
    getConnectionData() {
      const { connection } = this.streamManager.stream;
      return JSON.parse(connection.data);
    },
    // toggleMic() {
    //   this.statusMic = !this.statusMic;
    // },
  },
};
</script>

<style>
a .video-area {
  position: relative;
  overflow: hidden;
  border: 1px solid red;
}

a .video-area .top {
  position: absolute;
  top: 2%;
  left: 90%;
  z-index: 2;
}

/* a .video-area .bottom {
  position: absolute;
  top: 150%;
  z-index: 2;
  transition: all 0.35s;
}

a:hover .bottom {
  top: 85%;
} */
</style>
