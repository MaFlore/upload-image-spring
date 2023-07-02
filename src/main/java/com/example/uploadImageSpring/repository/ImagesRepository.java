package com.example.uploadImageSpring.repository;

import com.example.uploadImageSpring.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    Images findByNomImage(String nomImage);
}
