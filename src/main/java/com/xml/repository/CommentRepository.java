package com.xml.repository;

import com.xml.model.CarModel;
import com.xml.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {

  //  @Query(value = "SELECT * FROM xml.comment cm WHERE cm.advertisement_id = :adId", nativeQuery = true)
    ArrayList<Comment> getAllByAdvertisement_id(Long adId);

    Comment findOneById(Long id);
}
