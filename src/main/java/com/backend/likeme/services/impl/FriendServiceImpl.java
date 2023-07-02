package com.backend.likeme.services.impl;

import com.backend.likeme.entities.User;
import com.backend.likeme.exceptions.ResourceNotFoundException;
import com.backend.likeme.repositories.UserRepo;
import com.backend.likeme.services.FriendService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addFriend(String userEmail, Integer friendId) {
        User user = this.userRepo.findByEmail(userEmail).get();
        User friend = this.userRepo.findById(friendId)
                .orElseThrow(() -> new ResourceNotFoundException("Friend", "friendId id", friendId));
        user.getFriends().add(friend);
        userRepo.save(user);
    }
}
