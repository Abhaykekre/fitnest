package com.example.fitnest.Controller;

import com.example.fitnest.Model.Attendance;
import com.example.fitnest.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark/{memberId}")
    public Attendance markAttendance(@PathVariable String memberId,
                                     @RequestParam(value = "date", required = false) String dateStr) {
        LocalDate date = (dateStr == null) ? LocalDate.now() : parseDateFlexible(dateStr);
        return attendanceService.markAttendanceForDate(memberId, date);
    }

    // GET: All attendance of a member
    @GetMapping("/member/{memberId}")
    public List<Attendance> getAttendance(@PathVariable String memberId) {
        return attendanceService.getAttendanceByMember(memberId);
    }

    @GetMapping("/member/{memberId}/date/{date}")
    public List<Attendance> getAttendanceByDate(@PathVariable String memberId, @PathVariable String date) {
        LocalDate localDate = parseDateFlexible(date);
        return attendanceService.getAttendanceByMemberAndDate(memberId, localDate);
    }

    // Helper method
    private LocalDate parseDateFlexible(String dateStr) {
        String[] formats = {
                "yyyy-MM-dd",
                "dd-MM-yyyy",
                "MM/dd/yyyy",
                "dd/MM/yyyy",
                "yyyy/MM/dd"
        };

        for (String fmt : formats) {
            try {
                return LocalDate.parse(dateStr, java.time.format.DateTimeFormatter.ofPattern(fmt));
            } catch (Exception ignored) { }
        }
        throw new IllegalArgumentException("Invalid date format. Supported formats: yyyy-MM-dd, dd-MM-yyyy, MM/dd/yyyy, dd/MM/yyyy, yyyy/MM/dd");
    }

    // DELETE: Delete attendance entry (optional)
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable String id) {
        attendanceService.deleteAttendance(id);
    }
}

