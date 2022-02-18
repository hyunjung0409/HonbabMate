<template>
  <div v-if="streamManager" class="box" align="center">
    <!-- <toolbar /> -->
    <div class="toolbar">
      <v-toolbar dense>
        <template>
          <v-row align="center">
            <v-col cols="9">
              <span>
                <b style="margin-left: 90px">
                  {{ profile.nickName }}
                </b>
              </span>
            </v-col>

            <!-- <v-spacer /> -->
            <!-- <dropdown-menu /> -->

            <v-col cols="3">
              <div class="dropdown-menu">
                <v-menu
                  v-model="menu"
                  :close-on-content-click="false"
                  :nudge-width="200"
                  left
                  offset-y
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      :value="3"
                      text
                      v-bind="attrs"
                      style="margin-left: 20px"
                      v-on="on"
                    >
                      <v-icon> mdi-dots-horizontal </v-icon>
                    </v-btn>
                  </template>

                  <v-card max-width="350">
                    <v-list>
                      <v-list-item>
                        <v-list-item-avatar>
                          <img :src="memberimage.url" alt="profile-picture" />
                        </v-list-item-avatar>

                        <v-list-item-content>
                          <v-list-item-title>
                            {{ profile.nickName }}
                          </v-list-item-title>
                          <v-list-item-subtitle>
                            좋아요 : {{ profile.cntOfLikes }}
                          </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                          <v-btn
                            :class="heart ? 'red--text' : ''"
                            icon
                            @click="toggleLike"
                          >
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
                          <v-chip v-for="food in profile.foods" :key="food">
                            {{ food }}
                          </v-chip>
                        </v-chip-group>
                      </div>

                      <v-list-item>
                        <v-list-item-title>또 뭐있지?</v-list-item-title>
                      </v-list-item>
                      <div class="px-4">
                        <v-chip-group active-class="primary--text" column>
                          <v-chip v-for="tag in profile.etc" :key="tag">
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
                          <v-btn
                            color="error"
                            text
                            @click="blockDialog = false"
                          >
                            차단
                          </v-btn>
                          <v-btn
                            color="primary"
                            text
                            @click="blockDialog = false"
                          >
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
                          <v-btn
                            color="error"
                            text
                            @click="reportDialog = false"
                          >
                            신고
                          </v-btn>
                          <v-btn
                            color="primary"
                            text
                            @click="reportDialog = false"
                          >
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
            </v-col>
          </v-row>
        </template>
      </v-toolbar>
    </div>
    <ov-video :stream-manager="streamManager" />
  </div>
</template>

<script>
import OvVideo from "@/components/chat_room/OvVideo";
import rest from "../../api/index.js";
// import Toolbar from "@/components/chat_room/Toolbar";
// import DropdownMenu from "./DropdownMenu.vue";

export default {
  name: "UserVideo",
  components: {
    OvVideo,
    // Toolbar,
    // DropdownMenu,
  },
  props: {
    streamManager: Object,
  },

  data: () => ({
    heart: false,
    menu: false,
    blockDialog: false,
    reportDialog: false,
    // showLikes: this.member.cntOfLikes,
    memberId: null,
    profile: null,
  }),

  computed: {
    clientData() {
      const { clientData } = this.getConnectionData();
      return clientData;
    },
    memberimage() {
      return this.$store.state.memberimage;
    },
  },

  created() {
    this.memberId = Number(this.clientData);
    console.log("memberId : ", this.memberId);
    const id = this.memberId;
    this.getProfile(id);
    console.log("memberimg", this.memberimage.url);
  },

  methods: {
    getConnectionData() {
      const { connection } = this.streamManager.stream;
      console.log("connection data : ", connection.data);
      return JSON.parse(connection.data);
    },

    async getProfile(id) {
      await rest
        .axios({
          method: "get",
          url: "/profile/" + id,
        })
        .then((res) => {
          console.log("res data : ", res.data);
          this.profile = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },

    toggleLike() {
      const id = this.memberId;
      if (this.heart) {
        this.dislike(id);
        this.heart = !this.heart;
      } else {
        this.like(id);
        this.heart = !this.heart;
      }
    },
    async dislike(id) {
      await rest
        .axios({
          method: "get",
          url: "/dislike/" + id,
        })
        .then((res) => {
          console.log("res data : ", res.data);
          this.profile.cntOfLikes = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async like(id) {
      await rest
        .axios({
          method: "get",
          url: "/like/" + id,
        })
        .then((res) => {
          console.log("res data : ", res.data);
          this.profile.cntOfLikes = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style></style>
