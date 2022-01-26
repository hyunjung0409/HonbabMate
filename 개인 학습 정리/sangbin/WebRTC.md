# WebRTC



### STUN 서버

* Session Traversal Uilities for NAT
  * NAT환경에서는 Private IP를 별도로 갖기 때문에 P2P 통신이 불가능.
  * STUN 서버에 요청을 보내고 서버로부터 자신의 Public IP를 받는다.
  * 이 Public IP를 이용하여 클라이언트는 시그널링을 하게 된다.



### TURN 서버

* Traversal Using Relays around NAT
  * NAT 보안 정책이 너무 엄격하거나, 두 Client가 같은 네트워크에 존재하는 등 STUN으로 해결되지 않는 경우 TURN 서버 사용.
  * STUN 서버 사용시 각 단말들이 직접 통신하지만, TURN은 인터넷망에 위치하는 TURN 서버를 경유하여 통신한다.



### ICE

* Interactive Connectivity Establishment
  * Client가 통신 가능한 모든 주소를 식별하는것







1:N 통신으로 스트리밍하는 서비스 : 중간에 Media 서버로 중계하지 않으면, 모든 Peer가 매쉬 구조로 연결되어 각 Peer에 엄청난 부담을 줌. 네트워크 자원도 과하게 사용.

Media 서버가 각 Client와 Peer 관계를 맺어 단순 송수신을 하게 됨.

