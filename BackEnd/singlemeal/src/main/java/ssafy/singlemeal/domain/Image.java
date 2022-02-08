package ssafy.singlemeal.domain;

import lombok.Data;
import ssafy.singlemeal.file.UploadFile;

@Data
public class Image {

    private Long id;
    private UploadFile imageFile;


}
