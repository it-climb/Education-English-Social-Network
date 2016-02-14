package evg.testt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = UserAction.ACTION_NAME)
public class UserAction {

    public static final String ACTION_NAME = "actions";
    @Id
    private Long id;

    private String action;
    private String time;
    private User user;

    public UserAction() {
    }

    public UserAction(String action, String time, User user) {
        this.action = action;
        this.time = time;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
