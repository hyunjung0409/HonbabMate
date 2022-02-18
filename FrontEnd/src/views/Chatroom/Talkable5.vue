<template>
  <v-main>
    <v-container v-if="session" id="session" fluid>
      <v-row
        id="session-header"
        outlined
        justify="center"
        class="grey lighten-3"
        style="color: #616161"
      >
        <v-col cols="3" align="start">
          <h4 id="session-title" class="mx-3">채팅룸 {{ mySessionId }}</h4>
        </v-col>
        <v-col cols="4" align="start">
          <h4 class="mx-3">
            5인👩🏻‍🤝‍🧑🏻👩🏻‍🤝‍🧑🏻🧍‍♀️ 즐거운 토크와 함께하는 식사🍜
          </h4>
        </v-col>
        <v-col cols="2" align="start">
          <!-- <span class="mx-3">남은 시간 {{ time }}</span> -->
          <h4>
            <timer />
          </h4>
        </v-col>
        <v-col cols="3" align="end">
          <v-btn
            id="buttonLeaveSession"
            class="mx-3"
            plain
            @click="leaveSession"
          >
            <h3>나가기</h3>
          </v-btn>
        </v-col>
      </v-row>

      <!-- <div id="main-video" class="col-md-6">
                <user-video :stream-manager="mainStreamManager" />
              </div> -->

      <v-row id="video-container" class="grey lighten-3" justify="space-around">
        <a style="cursor: default">
          <div class="video-area">
            <div class="bottom">
              <!-- 마이크 on/off 버튼 -->
              <v-btn
                v-if="this.publisher.properties.publishAudio"
                :value="1"
                icon
                class="mx-1"
                @click="toggleAudio"
              >
                <v-icon color="white"> mdi-microphone </v-icon>
              </v-btn>
              <v-btn v-else :value="2" icon class="mx-1" @click="toggleAudio">
                <v-icon color="white"> mdi-microphone-off </v-icon>
              </v-btn>

              <!-- 카메라 on/off 버튼 -->
              <v-btn
                v-if="this.publisher.properties.publishVideo"
                :value="2"
                icon
                @click="toggleVideo"
              >
                <v-icon color="white"> mdi-video </v-icon>
              </v-btn>
              <v-btn v-else :value="2" icon @click="toggleVideo">
                <v-icon color="white"> mdi-video-off </v-icon>
              </v-btn>
            </div>
            <user-video
              :stream-manager="publisher"
              @click.native="updateMainVideoStreamManager(publisher)"
            />
          </div>
        </a>

        <a
          v-for="sub in subscribers"
          :key="sub.stream.connection.connectionId"
          style="cursor: default"
        >
          <div class="video-area">
            <user-video
              :stream-manager="sub"
              @click.native="updateMainVideoStreamManager(sub)"
            />
            <!-- <user-video
              :key="sub.stream.connection.connectionId"
              :stream-manager="sub"
              @click.native="updateMainVideoStreamManager(sub)"
            /> -->
          </div>
        </a>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import axios from "axios";
import { OpenVidu } from "openvidu-browser";
import UserVideo from "@/components/chat_room/UserVideo";
import Timer from "@/components/Timer";
import rest from "../../api/index.js";

axios.defaults.headers.post["Content-Type"] = "application/json";

const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
  name: "Chatroom",
  components: {
    UserVideo,
    Timer,
  },

  data() {
    return {
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],

      // mySessionId: "SessionA",
      mySessionId: "", //room number로 설정?
      myUserName: "", //닉네임으로 설정
      // myUserName: "Participant" + Math.floor(Math.random() * 100),
    };
  },

  computed: {
    member() {
      return this.$store.state.member;
    },
  },

  created() {
    this.mySessionId = String(this.$store.state.member.sessionId);
    this.myUserName = String(this.$store.state.member.id);
    console.log("member", this.$store.state.member);
    this.joinSession();
  },

  // mounted() {},

  methods: {
    toggleAudio() {
      this.publisher.properties.publishAudio =
        !this.publisher.properties.publishAudio;
      this.publisher.publishAudio(this.publisher.properties.publishAudio);
    },
    toggleVideo() {
      this.publisher.properties.publishVideo =
        !this.publisher.properties.publishVideo;
      this.publisher.publishVideo(this.publisher.properties.publishVideo);
    },
    joinSession() {
      // --- Get an OpenVidu object ---
      this.OV = new OpenVidu();

      // --- Init a session ---
      this.session = this.OV.initSession();

      // --- Specify the actions when events take place in the session ---

      // On every new Stream received...
      this.session.on("streamCreated", ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
      });

      // On every Stream destroyed...
      this.session.on("streamDestroyed", ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });

      // On every asynchronous exception...
      this.session.on("exception", ({ exception }) => {
        console.warn(exception);
      });

      // --- Connect to the session with a valid user token ---

      // 'getToken' method is simulating what your server-side should do.
      // 'token' parameter should be retrieved and returned by your own backend
      this.getToken(this.mySessionId).then((token) => {
        this.session
          .connect(token, { clientData: this.myUserName })
          .then(() => {
            // --- Get your own camera stream with the desired properties ---

            let publisher = this.OV.initPublisher(undefined, {
              audioSource: undefined, // The source of audio. If undefined default microphone
              videoSource: undefined, // The source of video. If undefined default webcam
              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: true, // Whether you want to start publishing with your video enabled or not
              resolution: "400x300", // The resolution of your video
              frameRate: 30, // The frame rate of your video
              insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
              mirror: false, // Whether to mirror your local video or not
            });

            this.mainStreamManager = publisher;
            this.publisher = publisher;

            // --- Publish your stream ---

            this.session.publish(this.publisher);
          })
          .catch((error) => {
            console.log(
              "There was an error connecting to the session:",
              error.code,
              error.message
            );
          });
      });

      window.addEventListener("beforeunload", this.leaveSession);
    },

    leaveSession() {
      // --- Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();

      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;

      window.removeEventListener("beforeunload", this.leaveSession);
      this.matchout();
      this.$router.push({ name: "Home" });
    },

    async matchout() {
      await rest
        .axios({
          method: "get",
          url: "/member/matchOut/" + this.member.id,
        })
        .then((res) => {
          console.log("matchout :", res);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },

    /**
     * --------------------------
     * SERVER-SIDE RESPONSIBILITY
     * --------------------------
     * These methods retrieve the mandatory user token from OpenVidu Server.
     * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
     * the API REST, openvidu-java-client or openvidu-node-client):
     *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
     *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
     *   3) The Connection.token must be consumed in Session.connect() method
     */

    getToken(mySessionId) {
      return this.createSession(mySessionId).then((sessionId) =>
        this.createToken(sessionId)
      );
    },

    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessions
    createSession(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions`,
            JSON.stringify({
              customSessionId: sessionId,
            }),
            // (sessionId = this.$store.state.member.sessionId),
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.id))
          .catch((error) => {
            if (error.response.status === 409) {
              resolve(sessionId);
            } else {
              console.warn(
                `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`
              );
              if (
                window.confirm(
                  `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`
                )
              ) {
                location.assign(`${OPENVIDU_SERVER_URL}/accept-certificate`);
              }
              reject(error.response);
            }
          });
      });
    },

    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessionsltsession_idgtconnection
    createToken(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}/connection`,
            {},
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.token))
          .catch((error) => reject(error.response));
      });
    },
  },
};
</script>

<style scoped>
a .video-area {
  position: relative;
  overflow: hidden;
  /* width: 90%;
  margin: 30px auto 30px auto; */

  /* max-width: 640px; */
  /* width: 60%; */
  margin: 50px 10px 0px 10px;
}

a .video-area .bottom {
  position: absolute;
  top: 150%;
  right: 40%;
  z-index: 2;
  transition: all 0.32s;
}

a:hover .bottom {
  top: 85%;
}
</style>
