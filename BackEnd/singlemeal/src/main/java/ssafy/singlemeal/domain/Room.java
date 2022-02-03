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
}

