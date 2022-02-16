<template>
  <div class="toolbar">
    <v-toolbar dense>
      <template>
        <!-- <p amber--text>{{ this.$store.state.member.nickname }}</p> -->

        <v-spacer />
        <!-- <div class="mx-5" /> -->
        <dropdown-menu />
      </template>
    </v-toolbar>
  </div>
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

<style>
div .toolbar {
  width: 480px;
}
</style>
