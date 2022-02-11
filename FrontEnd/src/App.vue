<template>
  <v-app>
    <navbar />
    <v-main style="background-color: #eeeeee">
      <router-view></router-view>
    </v-main>
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
