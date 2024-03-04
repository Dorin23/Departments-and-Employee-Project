package utcn.departamentManager.DepartamentManagement.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController
{

        private final EmployeeService employeeService;

        @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/e")
    public List<Employe> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/e/{id}")
    public Employe getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create-employee")
    public Employe createEmployee(@RequestBody Employe employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("//{id}")
    public Employe updateEmployee(@PathVariable Integer id, @RequestBody Employe updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/managers/{departmentId}")
    public List<Employe>getAllManagersInDepartment(@PathVariable Integer departmentId){
        return employeeService.getAllManagersInDepartment(departmentId);
    }

    @GetMapping("/e/department/{departmentId}")
    public List<Employe> getAllEmployeePerDepartment(@PathVariable Integer departmentId){
        return employeeService.getAllEMployeePerDepartment(departmentId);
    }
}
