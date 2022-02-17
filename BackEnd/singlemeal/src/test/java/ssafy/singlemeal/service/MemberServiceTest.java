package ssafy.singlemeal.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.*;
import ssafy.singlemeal.repository.MemberRepository;
import ssafy.singlemeal.repository.RoomRepository;

import javax.persistence.EntityManager;


//@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired RoomService roomService;
    @Autowired RoomRepository roomRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        // given
        Room room = new Room();
        em.persist(room);

        Member member = new Member();
        String testEmail = "testEmail@naver.com";
        member.setEmail(testEmail);

        // when
        Long memberId = memberService.join(member);
        Member findmember = memberService.findOne(memberId);

        // then
        Assertions.assertSame(findmember.getEmail(),testEmail);

   }

    @Test
    public void 매칭() throws Exception{
        // given
        Room room1 = new Room(); // 대기방
        Room room2 = new Room();
        Room room3 = new Room();

        room2.setRoomOption(RoomOption.NONTALKABLE2);
        room3.setRoomOption(RoomOption.TALKABLE2);

        em.persist(room1);
        em.persist(room2);
        em.persist(room3);

        Member member1 = new Member();
        member1.setStatus(MemberStatus.ONLINE);
        member1.setOption("talkable2");

        // when

        // then

    }

    @Test
    public void 좋아요() throws Exception{
        Member member = new Member();
    }

    @Test
    public void 프로필_수정() throws Exception{
        Member member = new Member();
    }

    @Test
    public void 프로필_조회() throws Exception{
        Member member = new Member();
    }

}

