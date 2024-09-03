package tn.zeros.smg.controllers;

import lombok.extern.slf4j.Slf4j;
import tn.zeros.smg.entities.Payroll;
import tn.zeros.smg.entities.User;
import tn.zeros.smg.services.PayrollService;
import org.springframework.web.bind.annotation.*;
import tn.zeros.smg.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@Slf4j
@RequestMapping("/api/payrolls")
public class PayrollController {
    private final PayrollService service;
    private final UserService userService;

    public PayrollController(PayrollService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Payroll getPayrollById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Payroll> getPayrollsByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        User user = userService.findById(payroll.getUser().getId());
        payroll.setUser(user);
        return service.save(payroll);
    }


    @PutMapping("/{id}")
    public Payroll updatePayroll(@PathVariable Long id, @RequestBody Payroll payroll) {
        payroll.setId(id);
        return service.save(payroll);
    }

    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Long id) {
        service.deleteById(id);
    }
}
