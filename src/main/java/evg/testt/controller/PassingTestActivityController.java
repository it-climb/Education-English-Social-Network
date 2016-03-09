package evg.testt.controller;

import evg.testt.dto.PassingTestActivityDto;
import evg.testt.model.User;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

@Controller
public class PassingTestActivityController {

    @Autowired
    private PassingTestActivityService passingTestActivityService;

    @Autowired
    private UserDataService userDataService;




//    @RequestMapping(value = "/passingTestActivity", method = RequestMethod.GET)
//    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
//
//        HttpSession session = request.getSession();
//        User sessionUser = (User) session.getAttribute("user");
////
//
//        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY);
//        //TsuccessestPassingActivity passingActivity = passingTestActivityService.getById(13);
//        TestPassingActivity passingActivity = new TestPassingActivity();
//        Activity activity = new Activity();
//        TestPassingActivityContent content = new TestPassingActivityContent();
//
//        passingActivity.setContent(content);
//        passingActivity.setActivity(activity);
//
//
//        activity.setName("name++++++++++++++activity");
//        activity.setAuthor(userDataService.findByUser(sessionUser));
//        List <PassingTestData> list = new ArrayList<>();
//        PassingTestData data1 = new PassingTestData();
//        data1.setQuestion("first question");
//        AnswersTestQuestion answersTestQuestion = new AnswersTestQuestion();
//
//
//        List<AnswerTestQuestion> listAnswer = new ArrayList<>();
//        AnswerTestQuestion answerTestQuestion = new AnswerTestQuestion();
//        answerTestQuestion.setAnswer("first answer");
////        answerTestQuestion.setAnswer("second answer");
////        answerTestQuestion.setAnswer("third answer");
//        listAnswer.add(answerTestQuestion);
//
//        answerTestQuestion = new AnswerTestQuestion();
//        answerTestQuestion.setAnswer("second answer");
//        listAnswer.add(answerTestQuestion);
//
//        answersTestQuestion.setAnswers(listAnswer);
//
//        data1.setAnswers(answersTestQuestion);
//
//        /*
//        AnswersTestQuestion answers2TestQuestion = new AnswersTestQuestion();
//
//        List<AnswerTestQuestion> list2 = new ArrayList<>();
//        AnswerTestQuestion answer2TestQuestion = new AnswerTestQuestion();
//        answer2TestQuestion.setAnswer("first answer2");
//        answer2TestQuestion.setAnswer("second answer2");
//        answer2TestQuestion.setAnswer("third answer2");
//        listAnswer.add(answer2TestQuestion);
//        answers2TestQuestion.setAnswers(list2);
//*/
//        PassingTestData data2 = new PassingTestData();
//        data2.setQuestion("second question");
//        //data2.setAnswers(answers2TestQuestion);
//        list.add(data1);
//        list.add(data2);
//        content.setItems(list);
//
//
//        //TestPassingActivityContent content = passingActivity.getContent();
//        //List<PassingTestData> data = content.getItems();
////        PassingTestData data = content.getItems();
////        List<String> list = new ArrayList<>();
////        for(PassingTestData p : data){
////            list.add(p.getQuestion());
////        }
//
//        modelAndView.addObject("passingActivity",passingActivity);
//
////        modelAndView.addObject("questions", list);
////        modelAndView.addObject("questions", data.getQuestion());
////        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
////        modelAndView.addObject("nameActivity", activity.getName());
////        modelAndView.addObject("activityId", activity.getId());
//
//        return modelAndView;
//    }

    @RequestMapping(value = "/passingTestActivity", method = RequestMethod.GET)
    public ModelAndView showOneActivity(HttpServletRequest request, @RequestParam(required = false) Integer id) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW);
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
            Activity activity = passingActivity.getActivity();

//        TestPassingActivityContent content = passingActivity.getContent();
//        List<PassingTestData> items = content.getItems();



            modelAndView.addObject("passingActivity", passingActivity);
//        modelAndView.addObject("items", items);
        return modelAndView;
    }

    @RequestMapping(value = "/editPassingTestActivity", method = RequestMethod.POST)
    public ModelAndView updateActivity(HttpServletRequest request, @RequestParam(required = false) Integer id) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD);
//        if(id != 0){
//            TestPassingActivity passingActivity = passingTestActivityService.getById(id);
//            Activity activity = passingActivity.getActivity();
//            PassingTestActivityDto dto = new PassingTestActivityDto();
//            dto.setName(activity.getName());
//            modelAndView.addObject("name", dto);
//        }



        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/saveOrUpdatePassingTestActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("ptaDto")PassingTestActivityDto dto, @RequestParam(required = false) Integer id,
                              HttpServletRequest request) throws SQLException {
//        if(id == 0) {

            HttpSession session = request.getSession();
            User sessionUser = (User) session.getAttribute("user");

            Activity activity = new Activity();
            activity.setType(ActivityType.PASSING_TEST_ACTIVITY);
            activity.setName(dto.getName());
            activity.setAuthor(userDataService.findByUser(sessionUser));

            TestPassingActivityContent content = new TestPassingActivityContent();


            TestPassingActivity passingActivity = new TestPassingActivity();
            passingActivity.setContent(content);
            passingActivity.setActivity(activity);
            passingTestActivityService.insert(passingActivity);
//        }
//        else {
//            passingTestActivityService.update(passingTestActivityService.getById(id));
//        }

        return "redirect:/passingActivities";


    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
    public ModelAndView addQuestions(HttpServletRequest request, @RequestParam(required = false) Integer id) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD_QUESTION);
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        modelAndView.addObject("passingActivity", passingActivity);




        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
    public ModelAndView editQuestion(HttpServletRequest request, @RequestParam(required = false) Integer id,
                                     @RequestParam(required = false) Integer numberQuestion) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD_QUESTION);
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
        PassingTestData item = list.get(numberQuestion - 1);
        PassingTestActivityDto dto = new PassingTestActivityDto();
        dto.setQuestion(item.getQuestion());
        List<AnswerTestQuestion> list1 = item.getAnswers().getAnswers();
        dto.setAnswer1(list1.get(0).getAnswer());
//        dto.setRightAnswer1(list1.get(0).isRightAnswer());
        dto.setAnswer2(list1.get(1).getAnswer());
//        dto.setRightAnswer2("true");
        dto.setAnswer3(list1.get(2).getAnswer());
//        dto.setRightAnswer3("true");
        dto.setAnswer4(list1.get(3).getAnswer());
//        dto.setRightAnswer4("true");
        modelAndView.addObject("ptaDto", dto);
        modelAndView.addObject("passingActivity", passingActivity);
        modelAndView.addObject("numberQuestion", numberQuestion);

        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("ptaDto")PassingTestActivityDto dto, @RequestParam(required = true) Integer id,
                              @RequestParam(required = false) Integer numberQuestion,
                              HttpServletRequest request) throws SQLException{

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> data = content.getItems();
        if (data == null){
            data = new ArrayList<>();
        }
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
            if (list.get(i).isRightAnswer() != null && !list.get(i).isRightAnswer().equals("")) {
                count++;
            }
        }


        answersTestQuestion.setRigthCountAnswers(count);
        PassingTestData testData= new PassingTestData();
        testData.setQuestion(dto.getQuestion());
        testData.setAnswers(answersTestQuestion);
        if (numberQuestion == null) {
            testData.setNumberQuestion(data.size() + 1);
            data.add(testData);

        } else {
            testData.setNumberQuestion(numberQuestion);

            data.set(numberQuestion - 1, testData);
        }
        content.setItems(data);
        passingActivity.setContent(content);

        passingTestActivityService.update(passingActivity);

        return "redirect:/passingTestActivity?id=" + id;
    }

    @RequestMapping(value = "/showQuestion", method = RequestMethod.POST)
    public ModelAndView showQuestion(@RequestParam(required = false) Integer id, @RequestParam(required = false) Integer numberQuestion) throws SQLException {
        ModelAndView modelAndView;
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
        PassingTestData item = list.get(numberQuestion - 1);
        PassingTestActivityDto dto = new PassingTestActivityDto();
        dto.setQuestion(item.getQuestion());
        List<AnswerTestQuestion> list1 = item.getAnswers().getAnswers();
        dto.setAnswer1(list1.get(0).getAnswer());
//        dto.setRightAnswer1(list1.get(0).isRightAnswer());
        dto.setAnswer2(list1.get(1).getAnswer());
//        dto.setRightAnswer2("true");
        dto.setAnswer3(list1.get(2).getAnswer());
//        dto.setRightAnswer3("true");
        dto.setAnswer4(list1.get(3).getAnswer());
//        dto.setRightAnswer4("true");
        if (item.getAnswers().getRigthCountAnswers() == 1){
            modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_RADIO_QUESTION);

        } else {
            modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_CHECKBOX_QUESTION);

        }
        modelAndView.addObject("ptaDto", dto);
        modelAndView.addObject("passingActivity", passingActivity);
        modelAndView.addObject("numberQuestion", numberQuestion);


        return modelAndView;

    }
//@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
//    public String addQuestion(@ModelAttribute("ptaDto")PassingTestActivityDto dto, @RequestParam(required = true) Integer id,
//                              HttpServletRequest request) throws SQLException{
//
//        HttpSession session = request.getSession();
//        User sessionUser = (User) session.getAttribute("user");
//
//        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
//        TestPassingActivityContent content = passingActivity.getContent();
//        List<PassingTestData> data = content.getItems();
//        if (data == null){
//            data = new ArrayList<>();
//        }
//        AnswerTestQuestion answer1 = new AnswerTestQuestion();
//        answer1.setAnswer(dto.getAnswer1());
//        answer1.setRightAnswer(dto.isRightAnwer1());
//        AnswerTestQuestion answer2 = new AnswerTestQuestion();
//        answer2.setAnswer(dto.getAnswer2());
//        answer2.setRightAnswer(dto.isRightAnwer2());
//        AnswerTestQuestion answer3 = new AnswerTestQuestion();
//        answer3.setAnswer(dto.getAnswer3());
//        answer3.setRightAnswer(dto.isRightAnwer3());
//        AnswerTestQuestion answer4 = new AnswerTestQuestion();
//        answer4.setAnswer(dto.getAnswer4());
//        answer4.setRightAnswer(dto.isRightAnwer4());
//        List<AnswerTestQuestion> list = new ArrayList<>();
//        list.add(answer1);
//        list.add(answer2);
//        list.add(answer3);
//        list.add(answer4);
//
//        AnswersTestQuestion answersTestQuestion = new AnswersTestQuestion();
//        answersTestQuestion.setAnswers(list);
//        int count = 0;
//        for (int i = 0; i < 4; i++) {
//            if (list.get(i).isRightAnswer() != null) {
////
//                count++;
//            }
//        }
//        answersTestQuestion.setRigthCountAnswers(count);
//        PassingTestData testData= new PassingTestData();
//        testData.setQuestion(dto.getQuestion());
//        testData.setAnswers(answersTestQuestion);
//        testData.setNumberQuestion(data.size()+1);
//        data.add(testData);
//        content.setItems(data);
//        passingActivity.setContent(content);
//
//        passingTestActivityService.update(passingActivity);
//
//        return "redirect:/passingTestActivity?id=" + id;
//    }

    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public String deleteQuestion(@RequestParam(required = false) Integer numberQuestion, @RequestParam(required = false) Integer id) throws SQLException{
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems(); //!!!
        List<PassingTestData> newList = new ArrayList<>();
        for (PassingTestData data : list){
            if(numberQuestion != data.getNumberQuestion()){
                data.setNumberQuestion(newList.size() + 1);
                newList.add(data);
            }
        }
        content.setItems(newList);
        passingActivity.setContent(content);
        passingTestActivityService.update(passingActivity);


        return "redirect:/passingTestActivity?id=" + id;

    }

//    @RequestMapping(value = "/passingActivity", method = RequestMethod.GET)
//    public ModelAndView showActivity () throws SQLException{
//        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW);
//        TestPassingActivity passingActivity = passingTestActivityService.getById(13);
//        Activity activity = passingActivity.getActivity();
//        TestPassingActivityContent content = passingActivity.getContent();
//
//        modelAndView.addObject("nameAuthor", activity.getAuthor().getUser().getEmail());
//        modelAndView.addObject("nameActivity", activity.getName());
//
//        return modelAndView;
//    }

    @RequestMapping(value = "/passingActivities", method = RequestMethod.GET)
    public ModelAndView showAllActivities() throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_ALL);
        List<TestPassingActivity> list = passingTestActivityService.getAll();
        Map<String, Integer> st = new LinkedHashMap<>();
        for(TestPassingActivity activity : list){
            st.put(activity.getActivity().getName(), activity.getActivity().getId());
        }
        modelAndView.addObject("activities", st);
        return modelAndView;
    }
//@RequestMapping(value = "/passingActivities", method = RequestMethod.GET)
//    public ModelAndView showAllActivities() throws SQLException{
//        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_ALL);
//        List<TestPassingActivity> list = passingTestActivityService.getAll();
//        List<String> st = new ArrayList<>();
//        for(TestPassingActivity activity : list){
//            st.add(activity.getActivity().getName());
//        }
//        modelAndView.addObject("activities", st);
//        return modelAndView;
//    }

    @RequestMapping(value = "/deletePassingActivity", method = RequestMethod.POST)
    public String deleteActivity(@RequestParam(required = true) Integer id ) throws SQLException {
        passingTestActivityService.delete(passingTestActivityService.getById(id));
        return "redirect:/passingActivities";
    }

}
