package ssafy.singlemeal.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.domain.RoomOption;
import ssafy.singlemeal.domain.RoomStatus;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoomRepository {

    private final EntityManager em;

    public void save(Room room){
        em.persist(room);
    }

    public Long findByOption(String option){

        RoomOption roomOption = null;
        switch (option){
            case "talkable2": roomOption = RoomOption.TALKABLE2;
                break;
            case "nontalkable2": roomOption = RoomOption.NONTALKABLE2;
                break;
            case "talkable5": roomOption = RoomOption.TALKABLE5;
                break;
            case "nontalkable5": roomOption = RoomOption.NONTALKABLE5;
                break;
        }

        List<Room> result = em.createQuery("select r from Room r where r.roomOption = :option and r.status = :status" , Room.class)
                .setParameter("option", roomOption)
                .setParameter("status", RoomStatus.NOTFULL)
                .getResultList();

        if(result.size() == 0){
            return 1L;
        }else{
            return result.get(0).getId();
        }
    }

    public Room findOne(Long id){
        return em.find(Room.class, id);
    }

}
