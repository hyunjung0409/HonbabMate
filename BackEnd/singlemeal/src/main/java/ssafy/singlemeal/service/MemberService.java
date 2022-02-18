package ssafy.singlemeal.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.Member;
import ssafy.singlemeal.domain.MemberStatus;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.file.UploadFile;
import ssafy.singlemeal.repository.MemberRepository;
import ssafy.singlemeal.repository.RoomRepository;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public Long join(Member member){

        Member findMember = findByEmail(member.getEmail());
        if(findMember != null){
            findMember.setStatus(MemberStatus.ONLINE);
            return findMember.getId();
        }

        Room room = roomRepository.findOne(1L);
        member.setRoom(room);
        member.setStatus(MemberStatus.ONLINE);

        memberRepository.save(member);
        return member.getId();
    }

    public Member findByEmail(String email){
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if(member.getEmail().equals(email))
                return member;
        }

        return null;
    }

    @Transactional
    public void logout(Long id){
        Member member = memberRepository.findOne(id);
        member.setStatus(MemberStatus.OFFLINE);
        Room memberRoom = member.getRoom();
        if(memberRoom.getId() != 1L){
            // count + status
            memberRoom.setCount(memberRoom.getCount() - 1);
            member.setMemberOption(null);
            // roomId
            Room initRoom = roomRepository.findOne(1L);
            member.setRoom(initRoom);
        }

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

    @Transactional
    public Member updateProfile(Long id, String nickname, List<String> foods, List<String> etc) {

        Member member = memberRepository.findOne(id);
        member.setNickname(nickname);
        member.setFood(foods);
        member.setEtc(etc);

        return member;
//        member.setImagePath(uploadFile.getFullPath());
    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public Long likeMmeber(Long id) {
        Member member = memberRepository.findOne(id);
        return member.setCntOfLikes(member.getCntOfLikes()+1);
    }

    @Transactional
    public Long disLikeMember(Long id){
        Member member = memberRepository.findOne(id);
        return member.setCntOfLikes(member.getCntOfLikes()-1);
    }

    public Long countOnlines() {

        List<Member> members = memberRepository.findAll();
        Long cnt = 0L;
        for (Member member : members) {
            if(member.getStatus() == MemberStatus.ONLINE)
                cnt++;
        }
        return cnt;
    }

    @Transactional
    public void matchOutMember(Long id) {
        Member findMember = memberRepository.findOne(id);
        Room findRoom = roomRepository.findOne(findMember.getRoom().getId());

        findMember.setMemberOption(null);
        findMember.setRoom(roomRepository.findOne(1L));
        findRoom.setCount(findRoom.getCount() - 1);
    }
}
