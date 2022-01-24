<template>
  <v-app-bar app color="orange accent-1" flat height="80">
    <v-tab class="m1-n8" :to="{ name: 'Home' }"> HONBAB MATE</v-tab>

    <v-avatar
      :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'"
      size="32"
    ></v-avatar>

    <v-tabs centered class="ml-n9" color="grey darken-1">
      <v-tab v-for="link in links" :key="link.name" :to="link.route">
        {{ link.name }}
      </v-tab>
    </v-tabs>

    <v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="36">
    </v-avatar>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppBar",

  data: () => ({
    links: [
      { name: "About", route: `/about` },
      { name: "Manual", route: `/manual` },
      { name: "FAQ", route: `/FAQ` },
    ],
  }),
};
</script>
