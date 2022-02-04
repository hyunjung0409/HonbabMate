package ssafy.singlemeal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.Member;
import ssafy.singlemeal.domain.MemberStatus;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.repository.MemberRepository;
import ssafy.singlemeal.repository.RoomRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public Long join(Member member){

        Room room = roomRepository.findOne(1L);
        member.setRoom(room);
        member.setStatus(MemberStatus.ONLINE);
//        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void updateOption(Long id, String option){
        Member member = memberRepository.findOne(id);
        member.setOption(option);
    }

    @Transactional
    public void updateRoomId(Long memberId, Long roomId){
        Member member = memberRepository.findOne(memberId);
        Room room = roomRepository.findOne(roomId);
        member.setRoom(room);
        room.setCount(room.getCount()+1);
    }


//    private void validateDuplicateMember(Member member) {
//        List<Member> findMembers = memberRepository.findByName(member.getName());
//        if(!findMembers.isEmpty()){
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        }
//    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
