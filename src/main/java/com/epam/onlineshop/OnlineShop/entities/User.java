package com.epam.onlineshop.OnlineShop.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "isBlocked")
    private boolean isBlocked;

    @Column(name = "address", nullable = false)
    private String address;
}
