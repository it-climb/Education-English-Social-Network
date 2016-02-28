package evg.testt.model;

import evg.testt.util.validation.FieldEquals;
import evg.testt.util.validation.Unique;
import evg.testt.util.validation.UserEmail;

import evg.testt.util.validation.UserPassword;
import org.hibernate.validator.constraints.NotEmpty;



import javax.persistence.Entity;

import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity(name = "users")
@FieldEquals( field="password", equalsTo="confirmPassword" )
public class User extends BaseModel {

    @Unique(message = "This email already exists")
    @UserEmail(message = "Invalid email")
    private String email;

    @UserPassword(message = "Pleas use latin characters")
    @NotEmpty(message = "Please enter your password")
    @Size(min = 6, max = 16, message = "Your password must between 6 and 16 characters")
    private String password;

    @Transient
    @UserPassword
    @NotEmpty
    private String confirmPassword;


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder newBuilder(){return new User().new Builder();}

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            User.this.setId(id);
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password){
            User.this.password = password;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
