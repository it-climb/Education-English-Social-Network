package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Set<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public static Builder newBuilder() {
        return new Department().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Department.this.setId(id);
            return this;
        }

        public Builder setName(String name) {
            Department.this.name = name;

            return this;
        }

        public Department build() {
            return Department.this;
        }
    }

}
