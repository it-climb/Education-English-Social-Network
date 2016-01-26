package evg.testt.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "firstName", unique = true, nullable = false, length = 255)
    private String firstName;

    @Column(name = "secondName", unique = true, nullable = false, length = 255)
    private String secondName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "birthday", nullable = false)
    @Temporal(value=TemporalType.DATE)
    private Date birthday;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static Builder newBuilder() {
        return new Employee().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Employee.this.id = id;
            return this;
        }

        public Builder setFirstName(String name) {
            Employee.this.firstName = name;
            return this;
        }

        public Builder setSecondName(String name) {
            Employee.this.secondName = name;
            return this;
        }

        public Builder setAge(Integer age) {
            Employee.this.age = age;
            return this;
        }

        public Builder setDepartment(Department department) {
            Employee.this.department = department;
            return this;
        }

        public Employee build() {
            return Employee.this;
        }
    }

}
