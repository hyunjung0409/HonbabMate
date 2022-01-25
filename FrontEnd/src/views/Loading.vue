<template>
  <v-container fluid>
    <v-row>
      <v-col align="center">
        <span class="pl-3"> 당신과 함께 밥을 먹을 혼밥메이트를 찾고 있어요! </span>
      </v-col>
    </v-row>

    <v-row>
      <v-col align="center">
        <span>잠시만 기다려주세요!</span>
      </v-col>
    </v-row>

    <v-row>
      <v-progress-linear
        color="yellow darken-2"
        :active="show"
        :indeterminate="query"
        :query="true"
      ></v-progress-linear>
    </v-row>

    <v-row>
      <v-col align="center">
        <span class="pl-3"> 새로고침, 뒤로가기, 재접속을 하시면 대기시간이 더 길어집니다. </span>
        <v-btn
          :disabled="loading"
          class="ml-3"
          color="grey darken-3"
          :to="{ name: 'ChatOption' }"
          plain
        >
          뒤로가기
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Loading',

  data: () => ({
    value: 0,
    show: true,
    query: false,
    interval: 0,
    loading: '',
  }),

  mounted() {
    this.queryAndIndeterminate();
  },

  beforeDestroy() {
    clearInterval(this.interval);
  },

  methods: {
    queryAndIndeterminate() {
      this.query = true;
      this.show = true;
      this.value = 0;

      setTimeout(() => {
        this.query = false;

        this.interval = setInterval(() => {
          if (this.value === 100) {
            clearInterval(this.interval);
            console.log('여기서 넘어가는거?', this.value);
            // this.$router.push({ path: 'Chatroom' });
            this.$router.replace({ path: 'chatroom/two' });
            // this.show = false;
            // return setTimeout(this.queryAndIndeterminate, 2000);
          }
          this.value += 25;
          console.log('test', this.value);
        }, 1000);
      }, 2500);
    },
  },
};
</script>
