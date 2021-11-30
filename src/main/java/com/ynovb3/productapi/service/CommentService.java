package com.ynovb3.productapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ynovb3.productapi.model.Comment;
import com.ynovb3.productapi.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	public Comment upsert(Comment product) {
        return commentRepository.save(product);
    }
	
	public Optional<Comment> getComment(Integer id) {
		return commentRepository.findById(id);
	}

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

}
