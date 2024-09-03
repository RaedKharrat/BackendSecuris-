package tn.zeros.smg.controllers;

import lombok.extern.slf4j.Slf4j;
import tn.zeros.smg.entities.StageRequest;
import tn.zeros.smg.entities.User;
import tn.zeros.smg.services.StageRequestService;
import org.springframework.web.bind.annotation.*;
import tn.zeros.smg.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@Slf4j
@RequestMapping("/api/stagerequests")
public class StageRequestController {
    private final StageRequestService service;
    private final UserService userService;

    public StageRequestController(StageRequestService service, UserService userService)
    {
        this.userService = userService;
        this.service = service;
    }

    @GetMapping
    public List<StageRequest> getAllStageRequests() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StageRequest getStageRequestById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userUserId}")
    public List<StageRequest> getStageRequestsByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public StageRequest createStageRequest(@RequestBody StageRequest stageRequest) {
        User user = userService.findById(stageRequest.getUser().getId());
        stageRequest.setUser(user);
        return service.save(stageRequest);
    }

    @PutMapping("/approve/{id}")
    public StageRequest approveStageRequest(@PathVariable Long id) {
        return service.approveStage(id);
    }

    @PutMapping("/reject/{id}")
    public StageRequest rejectStageRequest(@PathVariable Long id) {
        return service.rejectStage(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStageRequest(@PathVariable Long id) {
        service.deleteById(id);
    }
}
