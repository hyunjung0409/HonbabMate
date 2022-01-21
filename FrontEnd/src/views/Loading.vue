<template>
  <v-main class="grey lighten-3">
    <v-container
      :color="`grey ${theme.isDark ? 'darken-2' : 'lighten-4'}`"
      fluid
    >
      <v-skeleton-loader class="mx-auto" max-width="300" type="card" />
    </v-container>
  </v-main>
</template>

<script>
export default {
  inject: {
    // Vuetify components provide
    // a theme variable that is
    // used to determine dark
    theme: {
      default: { isDark: false },
    },
  },
};
</script>

<style></style>
