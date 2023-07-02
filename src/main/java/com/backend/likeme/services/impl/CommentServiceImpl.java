package com.backend.likeme.services.impl;

import com.backend.likeme.entities.Comment;
import com.backend.likeme.entities.Post;
import com.backend.likeme.entities.User;
import com.backend.likeme.exceptions.ResourceNotFoundException;
import com.backend.likeme.payloads.CommentDto;
import com.backend.likeme.repositories.CommentRepo;
import com.backend.likeme.repositories.PostRepo;
import com.backend.likeme.repositories.UserRepo;
import com.backend.likeme.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);
		comment.setUser(user);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, String userEmail) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		User user = this.userRepo.findByEmail(userEmail).get();

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);
		comment.setUser(user);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

}
