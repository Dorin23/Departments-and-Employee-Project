package utcn.departamentManager.DepartamentManagement.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employe,Integer> {

    @Query("SELECT e FROM Employe e WHERE e.department.id = :departmentId AND e.manager IS NOT NULL ")
    List<Employe> findAllManagersInDepartment(@Param("departmentId")Integer departmentId);

    @Query("SELECT e FROM Employe e WHERE e.department.id = :departmentId")
    List<Employe> findAllEmployeesInDepartment(@Param("departmentId") Integer departmentId);
}

