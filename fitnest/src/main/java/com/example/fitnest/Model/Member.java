package com.example.fitnest.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "members")
public class Member {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private String membershipType;
}
