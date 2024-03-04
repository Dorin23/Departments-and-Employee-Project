package utcn.departamentManager.DepartamentManagement.Departament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.departamentManager.DepartamentManagement.Employee.Employe;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
   private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Integer id, Department updatedDepartment) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setDescription(updatedDepartment.getDescription());
            department.setParent(updatedDepartment.getParent());
            return departmentRepository.save(department);
        }
        return null;
    }
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
    public List<Department> getSubDepartments(Integer parentId) {
        return departmentRepository.findAllByParentId(parentId);
    }

}
