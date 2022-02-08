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

        <v-col class="mt-9" cols="3">
          <div>
            <p>닉네임 : 혼밥메이트206</p>
          </div>
          <div>
            <p>좋아요 받은 수 :</p>
          </div>
        </v-col>

        <v-col class="mt-11" cols="6">
          <v-btn rounded color="primary" dark> 수정하기 </v-btn>
        </v-col>
      </v-row>

      <v-divider class="mt-11" />

      <v-list style="background-color: #eeeeee">
        <v-list-item>
          <v-list-item-title>최애음식</v-list-item-title>
        </v-list-item>
        <div class="px-4">
          <v-chip-group active-class="primary--text" column>
            <v-chip v-for="food in foods" :key="food">
              {{ food }}
            </v-chip>
          </v-chip-group>
        </div>

        <v-list-item>
          <v-list-item-title>또 뭐있지?</v-list-item-title>
        </v-list-item>
        <div class="px-4">
          <v-chip-group active-class="primary--text" column>
            <v-chip v-for="tag in tags" :key="tag">
              {{ tag }}
            </v-chip>
          </v-chip-group>
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
    ],
    tags: ["ESFP", "쿠킹덤", "여고추리반"],
  }),
};
</script>

<style lang=""></style>
