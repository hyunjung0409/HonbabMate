<template>
  <v-footer dark padless>
    <v-card class="flex" flat tile>
      <v-card-title class="grey lighten-1">
        <h6>C206 | SSAFY 6기 광주 캠퍼스</h6>

        <v-spacer />
        <h6>
          <a class="git" href="https://github.com/pia2011" style="color: white">
            김규성
          </a>
          |
          <a
            class="git"
            href="https://github.com/chaeryun"
            style="color: white"
          >
            김채련
          </a>
          |
          <a
            class="git"
            href="https://github.com/bangtugu"
            style="color: white"
          >
            송상빈
          </a>
          |
          <a class="git" href="https://github.com/Eooony" style="color: white">
            이정언
          </a>
          |
          <a
            class="git"
            href="https://github.com/hyunjung0409"
            style="color: white"
          >
            이현정
          </a>
        </h6>
        <v-spacer />
        <v-btn class="mx-1" dark icon>
          <v-icon size="20px" @click="moveGitlab"> mdi-gitlab </v-icon>
        </v-btn>
        <v-btn class="mx-1" dark icon>
          <v-icon size="20px" @click="moveNotion"> mdi-alpha-n-circle </v-icon>
        </v-btn>
      </v-card-title>
    </v-card>
  </v-footer>
</template>

<script>
import "@/assets/SCSS/common.scss";

export default {
  name: "Footer",

  methods: {
    moveGitlab() {
      window.open("https://lab.ssafy.com/s06-webmobile1-sub2/S06P12C206");
    },
    moveNotion() {
      window.open(
        "https://www.notion.so/c206/C206-fc207479a6f94484aafcae18136489e3"
      );
    },
  },
};
</script>

<style>
a :visited {
  color: white;
}
</style>
