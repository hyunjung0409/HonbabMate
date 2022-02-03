package ssafy.singlemeal.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ssafy.singlemeal.domain.Room;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RoomRepository {

    private final EntityManager em;

    public void save(Room room){
        em.persist(room);
    }

    public Room findOne(Long id){
        return em.find(Room.class, id);
    }

//    public Room findRoomByOptions(Member member){
//
//        String jpql = "select r From Room r where r";
//
//        return new Room();
//    }

}
