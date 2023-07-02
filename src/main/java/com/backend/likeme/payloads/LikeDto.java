package com.backend.likeme.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LikeDto {

    private int id;

    private String type;

    private UserDto user;

}
