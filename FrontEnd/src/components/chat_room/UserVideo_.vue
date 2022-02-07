<template>
  <div v-if="streamManager" align="center">
    <a style="cursor: default">
      <div class="video-area">
        <div class="top">
          <div>
            <dropdown-menu>
              <!-- <v-chip class="ma-2" color="grey darken-1" text-color="white">
                <p>{{ clientData }}</p>
                <span>
                  <v-btn icon color="white" @click="toggleMore">
                    <v-icon> mdi-dots-horizontal-circle-outline </v-icon>
                  </v-btn>
                </span>
              </v-chip> -->
            </dropdown-menu>
          </div>
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
    <!-- <div class="mt-3" align="center">
      <p>{{ clientData }}</p>
    </div> -->
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
  overflow: hidden;
}

a .video-area .top {
  position: absolute;
  bottom: 150%;
  right: 90px;
  z-index: 2;
  transition: all 0.35s;
}

a .video-area .bottom {
  position: absolute;
  top: 150%;
  right: 100px;
  z-index: 2;
  transition: all 0.35s;
}

a:hover .top {
  bottom: 78%;
}

a:hover .bottom {
  top: 85%;
}
</style>
