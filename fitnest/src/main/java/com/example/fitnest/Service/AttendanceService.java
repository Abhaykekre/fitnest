package com.example.fitnest.Service;

import com.example.fitnest.Model.Attendance;
import com.example.fitnest.Model.Member;
import com.example.fitnest.Repository.AttendanceRepository;
import com.example.fitnest.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Attendance markAttendanceForDate(String memberId, LocalDate date) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member with ID " + memberId + " not found."));

        List<Attendance> existing = attendanceRepository.findByMemberAndDate(member, date);
        if (!existing.isEmpty()) {
            return existing.get(0);
        }

        Attendance attendance = new Attendance();
        attendance.setMember(member);
        attendance.setDate(date);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByMember(String memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member with ID " + memberId + " not found."));
        return attendanceRepository.findByMember(member);
    }

    public List<Attendance> getAttendanceByMemberAndDate(String memberId, LocalDate date) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member with ID " + memberId + " not found."));
        return attendanceRepository.findByMemberAndDate(member, date);
    }

    public void deleteAttendance(String id) {
        attendanceRepository.deleteById(id);
    }
}


