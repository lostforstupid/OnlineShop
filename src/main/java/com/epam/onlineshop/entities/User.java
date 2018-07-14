package com.epam.onlineshop.entities;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Collection;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "roleEnum", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role_enum roleEnum;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToMany
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
