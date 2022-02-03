package ssafy.singlemeal.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.*;
import ssafy.singlemeal.repository.MemberRepository;
import ssafy.singlemeal.repository.RoomRepository;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired RoomService roomService;
    @Autowired RoomRepository roomRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        // given
        Room room = new Room();
        em.persist(room);

        Member member1 = new Member();
        member1.setToken("Token1");

        Member member2 = new Member();
        member2.setToken("Token2");

        // when
        Long memberId1 = memberService.join(member1);
        Long memberId2 = memberService.join(member2);

        // then
        assertEquals(member1, memberRepository.findOne(memberId1));
        assertEquals(member1.getToken(), memberRepository.findOne(memberId1).getToken());
    }

    /**
     *
     * */

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
        member1.setToken("SOIJEOFOISEJ");
        member1.setStatus(MemberStatus.ONLINE);
        member1.setOption(MemberOption.TALKABLE2);

        // when
        memberService.join(member1);

        // then
    }

}

