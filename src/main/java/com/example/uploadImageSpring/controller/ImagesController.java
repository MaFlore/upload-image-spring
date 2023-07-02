package com.example.uploadImageSpring.controller;

import com.example.uploadImageSpring.model.Images;
import com.example.uploadImageSpring.repository.ImagesRepository;
import com.example.uploadImageSpring.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    public Images uploadImage(@RequestParam("images") MultipartFile imageFile) throws IOException {
        Images images = this.imagesService.enregistrer(imageFile);
        return images;
    }

    @RequestMapping(value = "/image/details/{nomImage}", method = RequestMethod.GET)
    public Images detailsImage(@PathVariable("nomImage") String nomImage) throws IOException {
        Images images = this.imagesService.getImagesDetails(nomImage);
        return images;
    }

    @RequestMapping(value = "/construire/image/{nomImage}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("nomImage") String nomImage) throws IOException {
        byte[] images = imagesService.getImage(nomImage);
        Images images1 = this.imagesService.getImagesDetails(nomImage);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(images1.getType()))
                .body(images);
    }
}
