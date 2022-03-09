# 👩‍🍳WebRTC 기반 프로젝트 - 혼밥메이트
- 혼밥하는 사람들을 랜덤으로 매칭하여 실시간으로 서로의 식사를 공유
- 무음방/토크방으로 나누어 조용히 식사만 하고 싶은 사람, 식사 도중 간단히 얘기를 나누고 싶은 사람들을 따로 매칭
- 2인방/5인방 제공

[혼밥메이트 둘러보기](https://i6c206.p.ssafy.io/)

## 프로젝트 소개
* 프로젝트명: 혼밥메이트
* 서비스 특징: 혼밥러들을 위한 웹 기반 랜덤 매칭 화상채팅 서비스

## 프로젝트 기간
*  2022.01.10 ~ 2022.02.18 (6주)

## 팀 소개
- 팀 구성: Frontend 2명, Backend 2명
- 주 역할: 팀장. Frontend 개발
- 구현 기능
  - 화상통화 옵션, 그룹 화상 통화 구현 
  - 사용자 좋아요 · 싫어요 기능 구현
  - 화상통화 페이지에서 상대방 프로필 확인 기능 구현
  - 카카오 계정 정보를 기반으로 기본 프로필 제공하여 조회 · 수정 구현
  - 사용자를 표현하는 키워드를 추가하는 기능 구현


## 주요 기능
- Video call
  - 화상채팅 옵션 선택 가능 (인원/마이크)
  - 실시간 랜덤 매칭 제공
  - WebRTC 기반의 그룹 비디오 통화 제공
- Profile
  - 카카오 소셜 로그인 제공
  - 카카오 계정 기반의 프로필을 제공하여 조회/수정 가능
  - 상대방 프로필을 제공
- User
  - 좋아요/싫어요 기능
  - 온라인 인원 실시간 카운트 기능

## 기술 스택
  - Frontend : Vue.js, Vuetify, HTML/CSS/JavaScript
  - Backend : Spring Boot, JPA(Hibernate), Swagger, Junit 5
  - Storage : MySQL, H2
  - Deploy : AWS EC2
  - WebRTC : openVidu

## 기능 구현
#### 메인 페이지
<img src="./개인 학습 정리/hyunjung/화면 설계/Main.PNG"/>

#### 인원 옵션 선택
<img src="./개인 학습 정리/hyunjung/화면 설계/option1.PNG"/>

#### 마이크 옵션 선택
<img src="./개인 학습 정리/hyunjung/화면 설계/option2.PNG"/>

#### 로딩 페이지
<img src="./개인 학습 정리/hyunjung/화면 설계/loading.PNG"/>

#### 그룹 비디오 통화
<img src="./개인 학습 정리/hyunjung/화면 설계/two.PNG"/>
<img src="./개인 학습 정리/hyunjung/화면 설계/five.PNG"/>

#### 로그인
<img src="./개인 학습 정리/hyunjung/화면 설계/login.PNG"/>

#### 프로필 페이지
<img src="./개인 학습 정리/hyunjung/화면 설계/profile.PNG"/>

#### 사이트 이용법
<img src="./개인 학습 정리/hyunjung/화면 설계/manual.PNG"/>

#### 자주 하는 질문
<img src="./개인 학습 정리/hyunjung/화면 설계/faq.PNG"/>

## 보고서
<img src="./개인 학습 정리/hyunjung/화면 설계/혼밥메이트.gif"/>

### 상세 설명
[노션에서 확인하기](https://www.notion.so/c206/BE-8fd47b17b4f14222a5f5e6a9a005582e)

### 배포 메뉴얼
[노션에서 확인하기](https://www.notion.so/c206/263cd15cbf004e80807c40a86b72aedb)

### 외부 서비스
[노션에서 확인하기](https://www.notion.so/c206/f89cde933e56499197ae7322b25911db)

