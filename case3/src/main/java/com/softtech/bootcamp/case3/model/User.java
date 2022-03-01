package com.softtech.bootcamp.case3.model;

import com.softtech.bootcamp.case3.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "UK_USER_USERNAME",columnNames = {"username"}),
        @UniqueConstraint(name = "UK_USER_EMAIL",columnNames = {"email"} ),
        @UniqueConstraint(name = "UK_USER_PHONE_NUMBER", columnNames = {"phone_number"})})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 35, nullable = false)
    private String username;

    @Column(name = "email", length = 35, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 30)
    private UserType type;

}
