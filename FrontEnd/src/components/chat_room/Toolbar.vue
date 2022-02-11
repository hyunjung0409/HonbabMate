<template>
  <v-toolbar dense>
    <template v-if="$vuetify.breakpoint.mdAndUp">
      <!-- <p amber--text>{{ this.$store.state.member.nickname }}</p> -->

      <v-spacer />
      <!-- <div class="mx-5" /> -->
      <dropdown-menu />
    </template>
  </v-toolbar>
</template>

<script>
import DropdownMenu from "./DropdownMenu.vue";

export default {
  name: "Toolbar",

  components: {
    DropdownMenu,
  },
};
</script>
