package ssafy.singlemeal.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${spring.servlet.multipart.location}")
    private String fileDir;

    public String getFullPath(String fileName){
        return fileDir + fileName;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty())
            return null;

        String originalFileName = multipartFile.getOriginalFilename();
        String storeFileName = createStoreName(originalFileName);
        String fullPath = getFullPath(storeFileName);

        multipartFile.transferTo(new File(fullPath));

        return new UploadFile(originalFileName, storeFileName, fullPath);
    }

    private String createStoreName(String originalFileName) {
        String ext = extractExt(originalFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }


}
