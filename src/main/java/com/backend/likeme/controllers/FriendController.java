package com.backend.likeme.controllers;

import com.backend.likeme.payloads.ApiResponse;
import com.backend.likeme.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("friend/{friendId}/add")
    public ApiResponse saveFriendByUser(Principal principal, @PathVariable Integer friendId) {
        this.friendService.addFriend(principal.getName(), friendId);
        return new ApiResponse("Friend is Successfully Added !!", true);
    }
}
