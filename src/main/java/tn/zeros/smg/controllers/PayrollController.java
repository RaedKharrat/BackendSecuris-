package tn.zeros.smg.controllers;

import tn.zeros.smg.entities.Payroll;
import tn.zeros.smg.services.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
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
