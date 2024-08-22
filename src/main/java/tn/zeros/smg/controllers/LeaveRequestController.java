package tn.zeros.smg.controllers;

import tn.zeros.smg.entities.LeaveRequest;
import tn.zeros.smg.services.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaverequests")
public class LeaveRequestController {
    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<LeaveRequest> getLeaveRequestsByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return service.save(leaveRequest);
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approveLeaveRequest(@PathVariable Long id) {
        return service.approveLeave(id);
    }

    @PutMapping("/reject/{id}")
    public LeaveRequest rejectLeaveRequest(@PathVariable Long id) {
        return service.rejectLeave(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        service.deleteById(id);
    }
}
