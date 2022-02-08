package ssafy.singlemeal.repository;

import org.springframework.stereotype.Repository;
import ssafy.singlemeal.domain.Image;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FileRepository {

    private Long sequence = 0L;
    private final Map<Long, Image> store = new HashMap<>();

    public void save(Image image){
        image.setId(++sequence);
        store.put(image.getId(), image);
    }
}
