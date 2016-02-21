package evg.testt.model.userActionModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = UserAction.ACTION_NAME)
public class UserAction implements Serializable {

    public static final String ACTION_NAME = "actions";

    @Id
    private Long id;

    private String userEmail;
    private List<Action> actions;

    public UserAction(){
    }

    public UserAction(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserAction(Long id, String userEmail, List<Action> actions) {
        this.id = id;
        this.userEmail = userEmail;
        this.actions = actions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
