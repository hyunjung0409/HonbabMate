<template>
  <div v-if="streamManager" align="center">
    <a style="cursor: default">
      <div class="video-area">
        <div class="top">
          <dropdown-menu />
        </div>

        <div class="bottom">
          <div @click="toggleLike">
            <v-btn icon color="pink">
              <v-icon>
                {{ this.statusLike ? "mdi-heart" : "mdi-heart-outline" }}
              </v-icon>
            </v-btn>
            <span>{{ this.statusLike ? "추천완료" : "추천하기" }}</span>
          </div>
        </div>

        <ov-video :stream-manager="streamManager" />
      </div>
    </a>
  </div>
</template>

<script>
import OvVideo from "@/components/chat_room/OvVideo";
import DropdownMenu from "@/components/chat_room/DropdownMenu";

export default {
  name: "UserVideo",

  components: {
    OvVideo,
    DropdownMenu,
  },

  props: {
    streamManager: Object,
  },

  data: () => ({
    statusLike: false,
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
    toggleLike() {
      this.statusLike = !this.statusLike;
    },
  },
};
</script>

<style>
a .video-area {
  position: relative;
  overflow: hidden;
}

a .video-area .top {
  position: absolute;
  top: 2%;
  left: 90%;
  z-index: 2;
}

a .video-area .bottom {
  position: absolute;
  top: 150%;
  z-index: 2;
  transition: all 0.35s;
}

a:hover .bottom {
  top: 85%;
}
</style>
