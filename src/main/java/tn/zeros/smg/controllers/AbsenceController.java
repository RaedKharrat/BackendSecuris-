package tn.zeros.smg.controllers;

import tn.zeros.smg.entities.Absence;
import tn.zeros.smg.entities.User;
import tn.zeros.smg.services.AbsenceService;
import org.springframework.web.bind.annotation.*;
import tn.zeros.smg.services.UserService;

import java.util.List;

@RestController
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
    public Absence createAbsence(@RequestBody Absence absence) {

        User user = userService.findById(absence.getUser().getId());
        absence.setUser(user);

        return service.save(absence);
    }

    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable Long id) {
        service.deleteById(id);
    }
}
