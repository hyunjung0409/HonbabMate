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
            <router-link :to="{ name: 'NumberOfPeople' }">
              <v-btn class="mx-3">나가기</v-btn>
            </router-link>
          </v-col>
        </v-row>
        <!-- <router-view /> -->
        <two-people></two-people>

        <v-row>
          <video-chat />
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import '@/assets/SCSS/common.scss';
import VideoChat from '@/views/VideoChat.vue';
import TwoPeople from '@/components/chat_room/TwoPeople.vue';
import FivePeople from '@/components/chat_room/FivePeople.vue';

export default {
  name: 'Chatroom',
  components: {
    VideoChat,
    TwoPeople,
    FivePeople,
  },

  data: () => ({
    //
  }),
  created() {
    console.dir(this.$router);
    console.dir(this.$route);
    console.log(this.$route.path);
  },
};
</script>
