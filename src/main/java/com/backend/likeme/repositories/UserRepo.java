package com.backend.likeme.repositories;

import com.backend.likeme.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
