package utcn.departamentManager.DepartamentManagement.Departament;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Department {
    @Id
   private int id;
   private String description;
   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "parent_id")
   private Department parent;

    public Department() {

    }

    public Department(int id, String description, Department parentID) {
        this.id = id;
        this.description=description;
        parent=parentID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }
}
