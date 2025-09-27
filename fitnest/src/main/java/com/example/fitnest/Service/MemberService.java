package com.example.fitnest.Service;

import com.example.fitnest.Model.Member;
import com.example.fitnest.Repository.AttendanceRepository;
import com.example.fitnest.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(String id, Member updatedMember) {
        return memberRepository.findById(id)
                .map(existingMember -> {
                    existingMember.setName(updatedMember.getName());
                    existingMember.setAge(updatedMember.getAge());
                    existingMember.setGender(updatedMember.getGender());
                    existingMember.setMembershipType(updatedMember.getMembershipType());
                    return memberRepository.save(existingMember);
                }).orElse(null);
    }

    // Delete single member + attendance
    public void deleteMember(String id) {
        Optional<Member> memberOpt = memberRepository.findById(id);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            // Delete attendance first
            attendanceRepository.deleteAll(attendanceRepository.findByMember(member));
            // Delete member
            memberRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Member with ID " + id + " not found.");
        }
    }


    // Optional: Delete all members + their attendance
    public void deleteAllMembersAndAttendance() {
        attendanceRepository.deleteAll(); // Remove all attendances
        memberRepository.deleteAll();     // Remove all members
    }
}
