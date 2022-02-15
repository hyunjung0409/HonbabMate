package ssafy.singlemeal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Room {

    @Id @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    @OneToMany(mappedBy = "room")
    private List<Member> members = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @Enumerated(EnumType.STRING)
    private RoomOption roomOption;

    private LocalDate localDate;

    private int count;

    public void setCount(int count){
        this.count = count;
        if(this.roomOption.equals(RoomOption.NONTALKABLE2) || this.roomOption.equals(RoomOption.TALKABLE2)){
            if(this.count >= 2) setRoomStatus(RoomStatus.FULL);
            else setRoomStatus(RoomStatus.NOTFULL);
        }else if(this.roomOption.equals(RoomOption.TALKABLE5)|| this.roomOption.equals(RoomOption.NONTALKABLE5)){
            if(this.count >= 5) setRoomStatus(RoomStatus.FULL);
            else setRoomStatus(RoomStatus.NOTFULL);

        }
    }

    public void setRoomStatus(RoomStatus roomStatus){
        this.status = roomStatus;
    }
}

