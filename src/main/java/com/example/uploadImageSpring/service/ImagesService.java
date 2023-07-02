package com.example.uploadImageSpring.service;

import com.example.uploadImageSpring.model.Images;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImagesService {

    Images enregistrer(MultipartFile multipartFile) throws IOException;
    Images getImagesDetails(String nomImage) throws IOException;
    byte[] getImage(String nomImage) throws IOException;
}
