package utcn.departamentManager.DepartamentManagement.Departament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findAllByParentId(Integer parentId);
}
