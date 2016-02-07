package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "chat")
public class Chat extends BaseModel{

    @ManyToOne
    private User user;

    private String receiver;

    private String message;

    public String getReceiver() {return receiver;}

    public Chat setReceiver(String receiver) {this.receiver = receiver;
        return null;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Builder newBuilder() {
        return new Chat().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setMessage(String message){
            Chat.this.message = message;
            return this;
        }

        public Builder setReceiver(String receiver){
            Chat.this.receiver = receiver;
            return this;
        }

        public Builder setId(Integer id) {
            Chat.this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            Chat.this.user = user;
            return this;
        }

        public Chat build() {
            return Chat.this;
        }
    }

}
