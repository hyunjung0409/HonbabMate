package ssafy.singlemeal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.singlemeal.domain.Image;
import ssafy.singlemeal.repository.FileRepository;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public void saveImage(Image image){
        fileRepository.save(image);

    }
}
