<template>
  <!-- <v-app id="chat-option"> -->
  <v-app>
    <v-main>
      <v-container>
        <!-- <v-row>
          <v-card>
            <v-card-title>
              $vuetify.breakpoint.name: {{ $vuetify.breakpoint.name }}
            </v-card-title>
          </v-card>
        </v-row> -->

        <v-row align="center" class="grey lighten-1">
          <v-col cols="6">
            <span class="mx-3">Chat Room - 206</span>
            <span class="mx-3">2인👩🏻‍🤝‍🧑🏻 조용히 식사하는 방🍜 </span>
          </v-col>
          <v-col cols="3">
            <span class="mx-3">남은 시간 45:30</span>
          </v-col>
          <v-col cols="3" align="end">
            <v-btn class="mx-3">나가기</v-btn>
          </v-col>
        </v-row>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import '@/assets/SCSS/common.scss';

export default {
  name: 'Chatroom',
};
</script>
