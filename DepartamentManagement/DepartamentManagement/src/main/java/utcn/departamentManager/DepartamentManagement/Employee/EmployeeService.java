package utcn.departamentManager.DepartamentManagement.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.departamentManager.DepartamentManagement.Departament.Department;

import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employe> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employe getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employe createEmployee(Employe employee) {
        return employeeRepository.save(employee);
    }

    public Employe updateEmployee(Integer id, Employe updatedEmployee) {
        Employe employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setManager(updatedEmployee.getManager());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    public List<Employe> getAllManagersInDepartment(Integer departmentId) {
        return employeeRepository.findAllManagersInDepartment(departmentId);
    }
    public List<Employe> getAllEMployeePerDepartment(Integer departmentId){
        return employeeRepository.findAllEmployeesInDepartment(departmentId);
    }

}
