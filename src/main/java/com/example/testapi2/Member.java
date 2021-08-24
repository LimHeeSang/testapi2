package com.example.testapi2;

import lombok.Data;

@Data
public class Member {

    private Long id;

    private String name;
    private String age;
    private String phoneNumber;

    public Member(String name, String age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
