package com.example.springsecuritywithjwt.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;
}
