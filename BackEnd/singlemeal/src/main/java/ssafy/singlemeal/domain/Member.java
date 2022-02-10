package ssafy.singlemeal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private String nickName;
    private String email;
    private String gender;
    private Long cntOfLikes = 0L;
    private String imagePath;

    @ElementCollection
    private List<String> etc = new ArrayList<>();

    @ElementCollection
    private List<String> food = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MemberStatus status;


    @Enumerated(EnumType.STRING)
    private MemberOption option;

    //==연관관계 메서드==//
    public void setRoom(Room room){
        this.room = room;
        room.getMembers().add(this);
    }

    public void setNickname(String nickName){
        this.nickName = nickName;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
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
//
//    public void setFoods(List<String> foods){
//
//        this.food = new MemberFood(foods.get(0),foods.get(1),foods.get(2));
//    }
//
//    public void setEtc(List<String> etc){
//        this.etc = new MemberEtc(etc.get(0), etc.get(1), etc.get(2));
//    }
//
//    public List<String> getFoods(){
//
//        List<String> foods = Arrays.asList(this.food.getFood1(), this.food.getFood2(), this.food.getFood3());
//
//        return foods;
//    }
//
//    public List<String> getEtc(){
//
//        List<String> etc = Arrays.asList(this.etc.getEtc1(), this.etc.getEtc2(), this.etc.getEtc3());
//        return etc;
//    }



}
