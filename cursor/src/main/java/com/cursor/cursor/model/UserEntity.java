package com.cursor.cursor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
 public class UserEntity {

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserEntity(String name, String email, String password, String roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(String name, String email, String password, boolean isActive, String roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }

            @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

    @Column(name="name")
        private String name;

        private String email;
        private String password;
        private boolean isActive;
        private String roles;

}

