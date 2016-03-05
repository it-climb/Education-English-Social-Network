package evg.testt.model.activitycontent;

import java.util.List;

public class AnswersTestQuestion {
    private List<AnswerTestQuestion> answers;
    private int rigthCountAnswers;

    public List<AnswerTestQuestion> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerTestQuestion> answers) {
        this.answers = answers;
    }

    public int getRigthCountAnswers() {
        return rigthCountAnswers;
    }

    public void setRigthCountAnswers(int rigthCountAnswers) {
        this.rigthCountAnswers = rigthCountAnswers;
    }
}
