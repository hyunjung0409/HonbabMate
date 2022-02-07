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

        // when

        // then

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
        member1.setStatus(MemberStatus.ONLINE);

        // when
        memberService.join(member1);

        // then
    }

}

