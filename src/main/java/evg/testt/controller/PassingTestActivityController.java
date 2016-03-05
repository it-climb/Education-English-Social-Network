package evg.testt.controller;

import evg.testt.dto.PassingTestActivityDto;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.model.activities.TestPassingActivity;
import evg.testt.model.activitycontent.AnswerTestQuestion;
import evg.testt.model.activitycontent.AnswersTestQuestion;
import evg.testt.model.activitycontent.PassingTestData;
import evg.testt.model.activitycontent.TestPassingActivityContent;
import evg.testt.service.PassingTestActivityService;
import evg.testt.service.UserDataService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PassingTestActivityController {

    @Autowired
    private PassingTestActivityService passingTestActivityService;

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/passingTestActivity", method = RequestMethod.GET)
    public ModelAndView showAll() throws SQLException {

        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY);
        TestPassingActivity passingActivity = passingTestActivityService.getById(1);
        Activity activity = passingActivity.getActivity();
        TestPassingActivityContent content = passingActivity.getContent();
//        List<PassingTestData> data = content.getItems();
        PassingTestData data = content.getItems();
//        List<String> list = new ArrayList<>();
//        for(PassingTestData p : data){
//            list.add(p.getQuestion());
//        }

        modelAndView.addObject("questions", data.getQuestion());
        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
        modelAndView.addObject("nameActivity", activity.getName());

        return modelAndView;
    }

    @RequestMapping(value = "/addPassingTestActivity", method = RequestMethod.GET)
    public ModelAndView showAddActivity(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD);
    }

    @RequestMapping(value = "/addPassingTestActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("ptaDto")PassingTestActivityDto dto,
                              HttpServletRequest request) throws SQLException{

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        Activity activity = new Activity();
        activity.setType(ActivityType.PASSING_TEST_ACTIVITY);
        activity.setName(dto.getName());
        activity.setAuthor(userDataService.findByUser(sessionUser));

        TestPassingActivityContent content = new TestPassingActivityContent();

        AnswerTestQuestion answer1 = new AnswerTestQuestion();
        answer1.setAnswer(dto.getAnswer1());
        answer1.setRightAnswer(dto.isRightAnwer1());
        AnswerTestQuestion answer2 = new AnswerTestQuestion();
        answer2.setAnswer(dto.getAnswer2());
        answer2.setRightAnswer(dto.isRightAnwer2());
        AnswerTestQuestion answer3 = new AnswerTestQuestion();
        answer3.setAnswer(dto.getAnswer3());
        answer3.setRightAnswer(dto.isRightAnwer3());
        AnswerTestQuestion answer4 = new AnswerTestQuestion();
        answer4.setAnswer(dto.getAnswer4());
        answer4.setRightAnswer(dto.isRightAnwer4());
        List<AnswerTestQuestion> list = new ArrayList<>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
        list.add(answer4);

        AnswersTestQuestion answersTestQuestion = new AnswersTestQuestion();
        answersTestQuestion.setAnswers(list);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (list.get(0).isRightAnswer() != null) {
//
                count++;
            }
        }
        answersTestQuestion.setRigthCountAnswers(count);
        PassingTestData testData= new PassingTestData();
        testData.setQuestion(dto.getQuestion());
        testData.setAnswers(answersTestQuestion);
        content.setItems(testData);

        TestPassingActivity passingActivity = new TestPassingActivity();
        passingActivity.setActivity(activity);
        passingActivity.setContent(content);
        passingTestActivityService.insert(passingActivity);


        return "redirect:/success";
    }



}
