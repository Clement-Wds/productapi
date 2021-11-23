package com.ynovb3.productapi.service;

import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Comment;
import com.ynovb3.productapi.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	public Comment upsert(Comment product) {
        return commentRepository.save(product);
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

}
