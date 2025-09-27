package com.example.fitnest.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "attendances")
public class Attendance {
    @Id
    private String id;

    @DBRef  // Reference to Member document
    private Member member;

    private LocalDate date;  // Date of attendance
}

