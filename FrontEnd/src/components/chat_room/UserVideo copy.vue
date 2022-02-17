<template>
  <div v-if="streamManager" align="center">
    <!-- <toolbar /> -->
    <div class="toolbar">
      <v-toolbar dense>
        <template>
          <!-- <p amber--text>{{ this.$store.state.member.nickname }}</p> -->
          <p>{{ clientData }}</p>
          <v-spacer />
          <!-- <div class="mx-5" /> -->
          <dropdown-menu />
        </template>
      </v-toolbar>
    </div>
    <ov-video :stream-manager="streamManager" />
  </div>
</template>

<script>
import OvVideo from "@/components/chat_room/OvVideo";
// import Toolbar from "@/components/chat_room/Toolbar";
import DropdownMenu from "./DropdownMenu.vue";

export default {
  name: "UserVideo",
  components: {
    OvVideo,
    // Toolbar,
    DropdownMenu,
  },

  props: {
    streamManager: Object,
  },

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
  },
};
</script>

<style>
div .toolbar {
  width: 480px;
}
</style>
