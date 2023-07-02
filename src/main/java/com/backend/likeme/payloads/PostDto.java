package com.backend.likeme.payloads;

import com.backend.likeme.entities.Like;
import com.backend.likeme.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;	
	
	private CategoryDto category;

	private UserDto user;
	private Set<CommentDto> comments=new HashSet<>();
	private Set<Like> likes=new HashSet<>();
	
	
	
	
	
	
}
