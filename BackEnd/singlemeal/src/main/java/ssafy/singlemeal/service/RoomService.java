package ssafy.singlemeal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.repository.RoomRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public void createRoom(Room room){
        roomRepository.save(room);
    }

//    public Long findRoomByOptions(String option1, int option2){
//
//        Room roomByOptions = roomRepository.findRoomByOptions(option1, option2);
//
//        return roomByOptions.getId();
//    }

    public Room findOne(Long id){
        return roomRepository.findOne(id);
    }


}
