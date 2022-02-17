<template>
  <v-container>
    <v-row justify="center" style="padding: 80px 0 0 0">
      <h2>
        <p style="color: #616161">혼밥메이트에 대한 궁금증을 풀어드립니다.</p>
      </h2>
    </v-row>
    <v-row justify="center" style="padding: 0 0 50px 0">
      <h4>
        <p style="color: #757575">
          자주 묻는 질문을 모아 정리하였습니다. 궁금한 내용이 있다면 아래
          게시글을 클릭하세요.
        </p>
      </h4>
    </v-row>

    <v-row justify="center">
      <v-expansion-panels style="background-color: #fafafa; width: 1200px">
        <v-expansion-panel>
          <v-expansion-panel-header>
            <b style="color: #616161"> 혼밥메이트 사용법이 궁금해요! </b>
            <template v-slot:actions>
              <v-icon color="amber"> $expand </v-icon>
            </template>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            혼밥메이트는 혼밥을 공유할 인원을 선택하고 마이크 On/Off 옵션을
            선택하면, 해당되는 옵션에 맞춰 혼밥메이트를 랜덤 매칭해주어
            온라인으로 같이 밥을 먹는 구조입니다. 매칭 후 채팅룸에서 1시간 동안
            혼밥 공유 및 대화를 나눌 수 있고 1시간이 지나면 자동으로 채팅룸에서
            나가게 됩니다.
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header>
            <b style="color: #616161">
              혼밥메이트는 어떤 사람들이 사용하나요?
            </b>
            <template v-slot:actions>
              <v-icon color="amber"> $expand </v-icon>
            </template>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            혼밥메이트는 혼밥을 공유하고 싶은, 새로운 사람을 만나기 어려운,
            온라인 친구를 구하고 싶은 혼밥러들이 사용하는 사이트입니다.<br />
            인원, 마이크 옵션 선택에 따라 혼밥메이트를 실시간으로 랜덤
            매칭해주어 다양한 사람들을 만날 수 있습니다. <br />혼밥메이트는
            단순한 랜덤매칭 서비스가 아닌 혼밥러들의 커뮤니티가 될 수 있는
            공간으로 발전하려 합니다.
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header>
            <b style="color: #616161"> 사용자간의 대화가 가능한가요? </b>
            <template v-slot:actions>
              <v-icon color="amber"> $expand </v-icon>
            </template>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            혼밥메이트는 기본적으로 마이크 On/Off 옵션을 제공합니다.
            <br />사용자가 마이크 On 옵션을 선택하면 매칭 후 자유롭게 대화가
            가능합니다. 이때, 마이크 On/Off 할 수 있는 버튼도 제공됩니다.
            <br />그러나 사용자가 마이크 Off 옵션을 선택하면 대화가
            불가능합니다. 이는 영상으로만 혼밥을 공유하고 싶은 유저를 위하여
            제공되는 옵션입니다.
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header>
            <b style="color: #616161"> 좋아요 기능은 무엇인가요? </b>
            <template v-slot:actions>
              <v-icon color="amber"> $expand </v-icon>
            </template>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            좋아요는 혼밥메이트 사용자간의 신뢰도를 측정한느 방식 중 하나입니다.
            <br />매칭 후 주어진 1시간 동안 매너있게 참가한 사용자에게 좋아요
            버튼을 눌러주세요.<br />
            좋아요 개수가 많은 사용자일수록 매너와 신뢰가 표시되니 언제나
            혼밥메이트와 함께 즐거운 식사를 하시기 바랍니다.
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header>
            <b style="color: #616161">
              혼밥메이트를 더욱 즐겁게 즐길 수 있는 팁을 알려주세요!
            </b>

            <template v-slot:actions>
              <v-icon color="amber"> $expand </v-icon>
            </template>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            ✔ <b> 프로필을 수정하세요 </b>
            <br />
            프로필은 자신을 나타낼 수 있는 하나의 방식입니다. <br />
            '최애음식' 항목에 좋아하는 음식을 추가해보세요! '또 뭐있지' 항목에도
            나를 나타내는 다양한 단어를 추가해보세요! MBTI를 추가하는 것도 좋은
            방법입니다!
            <br />
            매칭된 사용자의 프로필을 확인하고 키워드에 대한 얘기를 나눠보세요.
            1시간 동안 다양한 주제로 이야기 나눠보세요 :)
            <br /><br />

            ✔ <b> 좋아요 버튼을 눌러주세요</b> <br />
            매칭 후 주어진 1시간 동안 매너있게 참가한 사용자에게 좋아요 버튼을
            눌러주세요.<br />
            좋아요 개수는 많은 사용자일수록 매너와 신뢰를 측정하는 기준이
            됩니다. 상대방에게 많은 좋아요를 받아 랭킹을 높여보세요.
            <br />매시간 업데이트 되는 좋아요 랭킹에 본인의 닉네임을 볼 수
            있습니다!
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "FAQ",

  components: {},
};
</script>

<style></style>
