# aws



![aws](C:\Users\SSAFY\Desktop\pjt\aws.png)



AWS에 front, back, media 서버 docker 이미지 생성, 실행하여 배포

유저는 배포 URL (https://i6c206.p.ssafy.io/) 을 통해 AWS상에서 실행중인 서버에 접속하여 서비스 이용



배포 : FE, BE 개발자가 local storage에서 개발하여 push, aws에서 pull 받아 이미지 갱신해서 변경점 업데이트



해야하는 일

FE : 기존 웹페이지와 openvidu 연결

BE : 매칭시켜서 같은 화상회의방으로 연결시켜줄 수 있도록