package com.cursor.cursor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
 public class UserEntity {

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserEntity(String userName, String email, String password, String roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity(String userName, String email, String password, boolean isActive, String roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }

            @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String userName;
        private String email;
        private String password;
        private boolean isActive;
        private String roles;

}

