<template>
  <div v-if="streamManager" align="center">
    <a style="cursor: default">
      <div class="video-area">
        <div class="top">
          <dropdown-menu />
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
    statusMore: false,
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
    toggleMore() {
      this.statusMore = !this.statusMore;
    },
  },
};
</script>

<style>
a .video-area {
  position: relative;
  /* overflow: hidden; */
}

a .video-area .top {
  position: absolute;
  top: 2%;
  left: 90%;
  z-index: 2;
}
</style>
