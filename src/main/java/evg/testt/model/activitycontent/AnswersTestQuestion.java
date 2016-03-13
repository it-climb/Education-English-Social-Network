package evg.testt.model.activitycontent;

import java.util.List;

public class AnswersTestQuestion {
    private List<AnswerTestQuestion> answers;
    private int rightCountAnswers;

    public List<AnswerTestQuestion> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerTestQuestion> answers) {
        this.answers = answers;
    }

    public int getRightCountAnswers() {
        return rightCountAnswers;
    }

    public void setRightCountAnswers(int rightCountAnswers) {
        this.rightCountAnswers = rightCountAnswers;
    }
}
