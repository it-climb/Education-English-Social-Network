package evg.testt.model;

import javax.persistence.Entity;

@Entity(name = "users")
public class User extends BaseModel {

    private String email;

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

        public User build() {
            return User.this;
        }
    }
}
