package com.backend.likeme.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Getter
@Setter
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

}
