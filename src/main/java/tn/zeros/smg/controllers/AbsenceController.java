package tn.zeros.smg.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import tn.zeros.smg.entities.Absence;
import tn.zeros.smg.entities.User;
import tn.zeros.smg.services.AbsenceService;
import org.springframework.web.bind.annotation.*;
import tn.zeros.smg.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@Slf4j
@RequestMapping("/api/absences")
public class AbsenceController {
    private final AbsenceService service;
    private final UserService userService;

    public AbsenceController(AbsenceService service, UserService userService) {

        this.userService = userService;

        this.service = service;
    }

    @GetMapping
    public List<Absence> getAllAbsences() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Absence> getAbsencesByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody Absence absence) {
        User user = userService.findById(absence.getUser().getId());
        absence.setUser(user);

        Absence savedAbsence = service.save(absence);
        return ResponseEntity.ok(savedAbsence);
    }


    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable Long id) {
        service.deleteById(id);
    }
}
