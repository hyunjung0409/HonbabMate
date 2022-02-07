<template>
  <v-app>
    <navbar />
    <v-content style="background-color: #eeeeee">
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",
  components: {
    Navbar: () => import("@/components/layout/Navbar"),
  },

  data: () => ({
    //
  }),
};
</script>
