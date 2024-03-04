package utcn.departamentManager.DepartamentManagement.Departament;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DepartmentController {

        @Autowired
   private DepartmentService departmentService;

    @GetMapping("/all-departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }


    @GetMapping("/{parentId}/sub")
    public List<Department> getSubDepartments(@PathVariable Integer parentId) {
        return departmentService.getSubDepartments(parentId);
    }
}
