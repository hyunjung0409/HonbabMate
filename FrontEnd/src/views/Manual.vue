<template>
  <div class="manual">
    <v-container>
      <v-row align="center" justify="center">
        <v-carousel v-model="model" style="width: 985px">
          <v-carousel-item v-for="page in pages" :key="page.name">
            <v-sheet height="100%" tile>
              <v-row class="fill-height" align="center" justify="center">
                <img :src="page.picture" alt="img" height="480" />
              </v-row>
            </v-sheet>
          </v-carousel-item>
        </v-carousel>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "Manual",

  components: {},
  data: () => ({
    model: 0,
    pages: [
      { name: "login", picture: require("@/assets/loginpage.png") },
      { name: "people", picture: require("@/assets/peopleoption.png") },
      { name: "option", picture: require("@/assets/roomoption.png") },
      { name: "matching", picture: require("@/assets/matching.png") },
    ],
  }),
};
</script>

<style>
div .manual {
  padding: 100px 0 100px 0;
}
</style>
