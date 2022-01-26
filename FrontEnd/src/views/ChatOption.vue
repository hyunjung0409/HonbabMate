<template>
  <!-- <v-app id="chat-option"> -->
  <v-app>
    <v-main fluid>
      <v-container>
        <!-- <v-row>
          <v-card>
            <v-card-title>
              $vuetify.breakpoint.name: {{ $vuetify.breakpoint.name }}
            </v-card-title>
          </v-card>
        </v-row> -->

        <v-row>
          <v-col>
            <span class="pl-3"> 지금 XX명이 밥을 먹고 있어요 👩‍🍳👨‍🍳 </span>
          </v-col>
        </v-row>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import "@/assets/SCSS/common.scss";

export default {
  name: "ChatOption",
};
</script>

<style lang=""></style>
