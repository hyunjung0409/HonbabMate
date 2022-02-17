<template>
  <v-app>
    <!-- <navbar v-if="$route.name !== 'Chatroom'" /> -->
    <navbar
      v-if="
        $route.name !== 'talkable2' &&
        $route.name !== 'talkable5' &&
        $route.name !== 'nontalkable2' &&
        $route.name !== 'nontalkable5'
      "
    />
    <v-main style="background-color: #eeeeee">
      <router-view></router-view>
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import Footer from "@/components/layout/Footer";

export default {
  name: "App",
  components: {
    Navbar: () => import("@/components/layout/Navbar"),
    Footer,
  },

  data: () => ({
    //
  }),
};
</script>
