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

    private String nickname;
    private String email;
    private String gender;

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

    public void setOption(String option){
        switch (option){
            case "talkable2": this.option = MemberOption.TALKABLE2;
                break;
            case "nontalkable2": this.option = MemberOption.NONTALKABLE2;
                break;
            case "talkable5": this.option = MemberOption.TALKABLE5;
                break;
            case "nontalkable5": this.option = MemberOption.NONTALKABLE5;
                break;
        }
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
