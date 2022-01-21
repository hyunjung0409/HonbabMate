<template>
  <v-app>
    <navbar />

    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",
  components: {
    Navbar: () => import("@/components/Navbar"),
  },

  data: () => ({
    //
  }),
};
</script>
