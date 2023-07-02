package com.backend.likeme.repositories;

import com.backend.likeme.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Integer> {

}
