<template>
  <v-toolbar dense>
    <template v-if="$vuetify.breakpoint.mdAndUp">
      <!-- <v-overflow-btn
        :items="dropdown_edit"
        editable
        label="Select size"
        hide-details
        class="pa-0"
        overflow
      />

      <v-divider vertical /> -->

      <v-spacer />

      <v-btn-toggle
        v-model="toggle_multiple"
        color="amber darken-1"
        dense
        group
        multiple
      >
        <v-btn :value="1" text>
          <v-icon>mdi-format-bold</v-icon>
        </v-btn>

        <v-btn :value="2" text>
          <v-icon>mdi-format-italic</v-icon>
        </v-btn>
      </v-btn-toggle>

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

  data() {
    return {
      dropdown_edit: [
        { text: "100%" },
        { text: "75%" },
        { text: "50%" },
        { text: "25%" },
        { text: "0%" },
      ],
      toggle_multiple: [],
    };
  },
};
</script>
