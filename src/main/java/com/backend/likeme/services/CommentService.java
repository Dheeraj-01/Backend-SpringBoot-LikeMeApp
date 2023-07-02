package com.backend.likeme.services;

import com.backend.likeme.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);

	void deleteComment(Integer commentId);

}
