<template>
  <div v-if="streamManager" align="center">
    <toolbar />
    <ov-video :stream-manager="streamManager" />
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
