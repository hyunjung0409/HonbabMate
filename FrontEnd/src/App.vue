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
