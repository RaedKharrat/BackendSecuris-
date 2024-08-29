package tn.zeros.smg.controllers;

import tn.zeros.smg.entities.LeaveRequest;
import tn.zeros.smg.entities.User;
import tn.zeros.smg.services.LeaveRequestService;
import tn.zeros.smg.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaverequests")
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;
    private final UserService userService;

    public LeaveRequestController(LeaveRequestService leaveRequestService, UserService userService) {
        this.leaveRequestService = leaveRequestService;
        this.userService = userService;
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.findAll();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<LeaveRequest> getLeaveRequestsByUserId(@PathVariable Long userId) {
        return leaveRequestService.findByUserId(userId);
    }

    @PostMapping
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        // Fetch the User object from the user ID
        User user = userService.findById(leaveRequest.getUser().getId());
        leaveRequest.setUser(user);

        return leaveRequestService.save(leaveRequest);
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approveLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.approveLeave(id);
    }

    @PutMapping("/reject/{id}")
    public LeaveRequest rejectLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.rejectLeave(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteById(id);
    }
}
