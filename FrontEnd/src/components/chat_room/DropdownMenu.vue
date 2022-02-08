<template>
  <div class="text-center">
    <v-menu
      v-model="menu"
      :close-on-content-click="false"
      :nudge-width="200"
      left
      offset-y
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn :value="3" text v-bind="attrs" v-on="on">
          <v-icon> mdi-dots-horizontal </v-icon>
        </v-btn>
      </template>

      <v-card max-width="350">
        <v-list>
          <v-list-item>
            <v-list-item-avatar>
              <img
                src="https://cdn.vuetifyjs.com/images/john.jpg"
                alt="profile-picture"
              />
            </v-list-item-avatar>

            <v-list-item-content>
              <v-list-item-title>혼밥메이트206</v-list-item-title>
              <v-list-item-subtitle>
                좋아요 :
                <!-- 좋아요 : {{ countLike }} -->
              </v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-action>
              <v-btn :class="fav ? 'red--text' : ''" icon @click="fav = !fav">
                <v-icon>mdi-heart</v-icon>
              </v-btn>
            </v-list-item-action>
          </v-list-item>
        </v-list>

        <v-divider />

        <v-list>
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

        <v-divider />

        <v-dialog v-model="blockDialog" width="500">
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on"> 차단 </v-btn>
          </template>
          <v-card>
            <v-card-title class="text-h5 grey lighten-2">
              혼밥메이트206 님을 차단하시겠습니까?
            </v-card-title>

            <v-card-actions>
              <v-spacer />
              <v-btn color="error" text @click="blockDialog = false">
                차단
              </v-btn>
              <v-btn color="primary" text @click="blockDialog = false">
                취소
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>

        <v-dialog v-model="reportDialog" width="500">
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on"> 신고 </v-btn>
          </template>
          <v-card>
            <v-card-title class="text-h5 grey lighten-2">
              혼밥메이트206 님을 신고하시겠습니까?
            </v-card-title>

            <v-card-text>
              <v-textarea
                class="mt-5"
                label="신고 사유"
                auto-grow
                outlined
                rows="4"
                row-height="30"
              />
            </v-card-text>

            <v-divider />

            <v-card-actions>
              <v-spacer />
              <v-btn color="error" text @click="reportDialog = false">
                신고
              </v-btn>
              <v-btn color="primary" text @click="reportDialog = false">
                취소
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>

        <v-card-actions>
          <v-spacer />

          <v-btn text @click="menu = false"> 닫기 </v-btn>
        </v-card-actions>
      </v-card>
    </v-menu>
  </div>
</template>

<script>
export default {
  name: "DropdownMenu",
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

<style></style>
