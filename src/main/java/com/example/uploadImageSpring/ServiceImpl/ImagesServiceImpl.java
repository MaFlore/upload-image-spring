package com.example.uploadImageSpring.ServiceImpl;

import com.example.uploadImageSpring.model.Images;
import com.example.uploadImageSpring.repository.ImagesRepository;
import com.example.uploadImageSpring.service.ImagesService;
import com.example.uploadImageSpring.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Images enregistrer(MultipartFile multipartFile) throws IOException {

        Images images1 = imagesRepository.save(Images.builder()
                .nomImage(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .image(ImageUtil.compressImage(multipartFile.getBytes())).build());

        return images1;
    }

    @Override
    public Images getImagesDetails(String nomImage) throws IOException{
        Images images = imagesRepository.findByNomImage(nomImage);

        return Images.builder()
                .id(images.getId())
                .nomImage(images.getNomImage())
                .type(images.getType())
                .image(ImageUtil.decompressImage(images.getImage())).build();
    }

    @Override
    public byte[] getImage(String nomImage) throws IOException{
        Images images = imagesRepository.findByNomImage(nomImage);
        return ImageUtil.decompressImage(images.getImage());
    }
}
