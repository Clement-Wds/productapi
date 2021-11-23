package com.ynovb3.productapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynovb3.productapi.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
