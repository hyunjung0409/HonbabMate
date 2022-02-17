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

    public Long match(Long id, String option){
        return roomRepository.findByOption(option);
    }

    public Room findOne(Long id){
        return roomRepository.findOne(id);
    }



}
