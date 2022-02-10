<template>
  <v-main>
    <v-container>
      <v-row>
        <v-col cols="2">
          <v-avatar size="150">
            <img
              src="https://cdn.vuetifyjs.com/images/john.jpg"
              alt="profile-picture"
            />
          </v-avatar>
        </v-col>

        <v-col class="mt-10" cols="2">
          <div>
            <p>닉네임 : 혼밥메이트206</p>
          </div>
          <div>
            <p>좋아요 받은 수 :</p>
          </div>
        </v-col>

        <v-col class="mt-12" cols="2" align="center">
          <v-btn color="grey lighten-2" rounded depressed> 수정하기 </v-btn>
        </v-col>
        <v-col cols="6" />
      </v-row>

      <v-divider class="mt-12 mb-5" />

      <v-list style="background-color: #eeeeee">
        <v-list-item>
          <v-list-item-title max-width="200px"> 최애음식 </v-list-item-title>
          <v-btn text>
            <v-icon> mdi-plus </v-icon>
          </v-btn>
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="food in foods" :key="food" class="mr-2 mb-2">
            {{ food }}
          </v-chip>
        </div>

        <v-list-item>
          <v-list-item-title>또 뭐있지?</v-list-item-title>
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="tag in tags" :key="tag" class="mr-2 mb-2">
            {{ tag }}
          </v-chip>
        </div>
      </v-list>
    </v-container>
  </v-main>
</template>

<script>
export default {
  name: "Profile",
  data: () => ({
    fav: true,
    menu: false,
    blockDialog: false,
    reportDialog: false,
    foods: [
      "평양냉면",
      "마라로제떡볶이",
      "파히타",
      "레인보우샤베트",
      "마제소바",
      "평양냉면",
      "마라로제떡볶이",
      "파히타",
      "레인보우샤베트",
      "마제소바",
      "평양냉면",
      "마라로제떡볶이",
      "파히타",
      "레인보우샤베트",
      "마제소바",
    ],
    tags: ["ESFP", "쿠킹덤", "여고추리반"],
  }),
};
</script>

<style></style>
