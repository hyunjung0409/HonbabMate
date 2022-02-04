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

        <v-row
          align="center"
          class="grey lighten-1"
        >
          <v-col
            cols="6"
            align="start"
          >
            <span class="mx-3">Chat Room - 206</span>
            <span class="mx-3">2인👩🏻‍🤝‍🧑🏻 조용히 식사하는 방🍜 </span>
          </v-col>
          <v-col
            cols="3"
            align="start"
          >
            <span class="mx-3">남은 시간 45:30</span>
          </v-col>
          <v-col
            cols="3"
            align="end"
          >
            <v-btn
              class="mx-3"
              @click="exitPage"
            >
              나가기
            </v-btn>
          </v-col>
        </v-row>
        <!-- <router-view /> -->
        <v-row class="grey lighten-3">
          <v-col>
            <two-people />
          </v-col>
        </v-row>
        <!-- <v-row>
          <video-chat />
        </v-row> -->
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import '@/assets/SCSS/common.scss';
// import VideoChat from '@/views/VideoChat.vue';
import TwoPeople from '@/components/chat_room/TwoPeople.vue';
import FivePeople from '@/components/chat_room/FivePeople.vue';

export default {
  name: 'Chatroom',
  components: {
    // VideoChat,
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
  methods: {
    exitPage() {
      this.$router.push('/people');
    },
  },
};
</script>
