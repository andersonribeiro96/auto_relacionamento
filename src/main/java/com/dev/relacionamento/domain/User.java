package com.dev.relacionamento.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> following = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> followers = new HashSet<>();

    public void followUsers(User user){
        getFollowing().add(user);
    }


}
