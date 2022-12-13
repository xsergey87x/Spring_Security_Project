package com.cursor.cursor.model;

//@Entity
    public class UserEntity {

//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        private Long id;

    public UserEntity(String userName, String email, String password, String roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

        private String userName;
        private String email;
        private String password;

        private String roles;

}

