package com.backend.likeme.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Role {

	@Id	
	private int id;
	
	private String name;
	
}
