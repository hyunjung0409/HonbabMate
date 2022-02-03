package ssafy.singlemeal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private String name;

    private String token;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    private MemberOption option;

//    @Embedded
//    private MemberProfile memberProfile;

    //==연관관계 메서드==//
    public void setRoom(Room room){
        this.room = room;
        room.getMembers().add(this);
    }

    //==생성 메서드==//
//    public static Member createMember(Room room, String token){
//        Member member = new Member();
//        member.setRoom(room);
//        member.setToken(token);
//
//        member.setStatus(MemberStatus.ONLINE);
//        return member;
//    }
}
