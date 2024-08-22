package tn.zeros.smg.controllers;

import tn.zeros.smg.entities.StageRequest;
import tn.zeros.smg.services.StageRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagerequests")
public class StageRequestController {
    private final StageRequestService service;

    public StageRequestController(StageRequestService service) {
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
