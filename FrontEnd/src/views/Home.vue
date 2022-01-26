<template>
  <v-main>
    <v-container fluid>
      <!-- <v-row>
          <v-card>
            <v-card-title>
              $vuetify.breakpoint.name: {{ $vuetify.breakpoint.name }}
            </v-card-title>
          </v-card>
        </v-row> -->

      <v-row>
        <v-col align="center">
          <span class="pl-3"> 지금 XX명이 밥을 먹고 있어요 👩‍🍳👨‍🍳 </span>
        </v-col>
      </v-row>

      <v-row>
        <v-col align="center">
          <span class="mr-3 pa-3">
            2인 방 선택! 아래 옵션을 선택해주세요!
          </span>
          <v-btn
            :disabled="loading"
            class="ml-3"
            color="grey darken-3"
            plain
          >
            뒤로가기
          </v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col align="center">
          <v-btn
            class="mr-3"
            outlined
            color="orange darken-3"
            height="100"
            width="200"
            :to="{ name: 'Loading' }"
          >
            조용히 먹고 싶어요
          </v-btn>

          <v-btn
            class="ml-3"
            color="orange darken-1"
            dark
            height="100"
            width="200"
          >
            스몰토크 나누고 싶어요
          </v-btn>
        </v-col>
      </v-row>
      <!-- <v-row>
          <v-col align="space-around">
            <v-btn outlined color="orange darken-3" height="100" width="200">
              조용히 먹고 싶어요
            </v-btn>

            <v-btn color="orange darken-1" dark height="100" width="200">
              스몰토크 나누고 싶어요
            </v-btn>
          </v-col>
        </v-row> -->
    </v-container>
  </v-main>
</template>

<script>
export default {
  name: "Home",
  components: {},
};
</script>
