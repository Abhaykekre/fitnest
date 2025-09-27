package com.example.fitnest.Repository;


import com.example.fitnest.Model.Attendance;
import com.example.fitnest.Model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByMember(Member member);
    List<Attendance> findByMemberAndDate(Member member, LocalDate date);
}

