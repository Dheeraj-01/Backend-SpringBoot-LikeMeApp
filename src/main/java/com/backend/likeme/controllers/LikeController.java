package com.backend.likeme.controllers;

import com.backend.likeme.payloads.ApiResponse;
import com.backend.likeme.payloads.LikeDto;
import com.backend.likeme.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class LikeController {

	@Autowired
	private LikeService likeService;

	@PostMapping("/post/{postId}/user/{userId}/likes")
	public ResponseEntity<LikeDto> createLike(@RequestBody LikeDto like,
											  @PathVariable Integer postId,
											  @PathVariable Integer userId) {

		LikeDto createLike = this.likeService.createLike(like, postId, userId);
		return new ResponseEntity<LikeDto>(createLike, HttpStatus.CREATED);
	}

	@DeleteMapping("/likes/{likeId}")
	public ResponseEntity<ApiResponse> deleteLike(@PathVariable Integer likeId) {

		this.likeService.deleteLike(likeId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Like deleted successfully !!", true), HttpStatus.OK);
	}

}
