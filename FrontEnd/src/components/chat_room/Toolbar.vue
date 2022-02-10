<template>
  <v-toolbar dense>
    <template v-if="$vuetify.breakpoint.mdAndUp">
      <v-spacer />

      <v-btn-toggle v-model="toggle_multiple" dense group multiple>
        <v-spacer />
        <!-- <div class="mx-5" /> -->

        <dropdown-menu />
      </v-btn-toggle>
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

  data() {
    return {
      toggle_multiple: [],
    };
  },
};
</script>
