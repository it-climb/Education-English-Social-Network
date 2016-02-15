package evg.testt.model;

import evg.testt.util.converter.EmailConverter;
import evg.testt.util.converter.PasswordConverter;
import evg.testt.util.validation.Unique;
import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity(name = "users")

public class User extends BaseModel {

    @Unique(message = "This email already exists")
    @Email(message = "Invalid email")
    @Convert(converter = EmailConverter.class)
    private String email;

    @NotEmpty(message = "Please enter your password")
    @Size(min = 3, max = 16, message = "Your password must between 3 and 16 characters")
    @Convert(converter = PasswordConverter.class)
    private String password;

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
