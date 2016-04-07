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
public class ActivityPassingTestController {

    @Autowired
    private PassingTestActivityService passingTestActivityService;

    @Autowired
    private UserDataService userDataService;

    /**
     * the method show selected test activity
     *
     * @param request       it must be to get user from session
     * @param id            id selected activity
     * @return              show selected activity with questions
     * @throws              SQLException
     */
    @RequestMapping(value = "/passingTestActivity", method = RequestMethod.GET)
    public ModelAndView showOneActivity(HttpServletRequest request, @RequestParam(required = false) Integer id) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW);
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
         modelAndView.addObject("passingActivity", passingActivity);
        return modelAndView;
    }

    /**
     * edit selected activity
     *
     * @param request       it must be to get user from session
     * @param id            id selected activity
     * @return              show edit activity page
     * @throws              SQLException
     */
    @RequestMapping(value = "/editPassingTestActivity", method = RequestMethod.GET)
    public ModelAndView updateActivity(HttpServletRequest request, @RequestParam(required = false) Integer id) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD);
        if(id != null){
            TestPassingActivity passingActivity = passingTestActivityService.getById(id);
            Activity activity = passingActivity.getActivity();
            PassingTestActivityDto dto = new PassingTestActivityDto();
            dto.setName(activity.getName());
            dto.setId(id);
            modelAndView.addObject("ptaDto", dto);
        }
        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        return modelAndView;
    }

    /**
     * save new or update edited activity
     *
     * @param dto           object with data activity
     * @param request       it must be to get user from session
     * @return              page activity with questions
     * @throws              SQLException
     */
    @RequestMapping(value = "/saveOrUpdatePassingTestActivity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute("ptaDto")PassingTestActivityDto dto,
                              HttpServletRequest request) throws SQLException {

            HttpSession session = request.getSession();
            User sessionUser = (User) session.getAttribute("user");
        if (dto.getId() == null){
            Activity activity = new Activity();
            activity.setType(ActivityType.PASSING_TEST_ACTIVITY);
            activity.setName(dto.getName());
            activity.setAuthor(userDataService.findByUser(sessionUser));

            TestPassingActivityContent content = new TestPassingActivityContent();
            TestPassingActivity passingActivity = new TestPassingActivity();
            passingActivity.setContent(content);
            passingActivity.setActivity(activity);
            passingTestActivityService.insert(passingActivity);
        }
        else {
            TestPassingActivity passingActivity = passingTestActivityService.getById(dto.getId());
            Activity activity = passingActivity.getActivity();
            activity.setName(dto.getName());
            passingActivity.setActivity(activity);
            passingTestActivityService.update(passingActivity);
        }

        return "redirect:/activities";
//        return "redirect:/passingActivities";
    }

    /**
     * show all passing test activities for author with opportunity to create, edit and delete activities
     *
     * @return              page with all test activities
     * @throws              SQLException
     */
    @RequestMapping(value = "/passingActivities", method = RequestMethod.GET)
    public ModelAndView showAllActivitiesAuthor() throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_ALL);
        List<TestPassingActivity> list = passingTestActivityService.getAll();
        Map<String, Integer> st = new LinkedHashMap<>();
        for(TestPassingActivity activity : list){
            st.put(activity.getActivity().getName(), activity.getActivity().getId());
        }
        modelAndView.addObject("activities", st);
        return modelAndView;
    }

    /**
     * show all passing test activities for user with opportunity to pass test any activity
     *
     * @return              page with all test activities any of which has one or more questions
     * @throws              SQLException
     */
    @RequestMapping(value = "/passingActivitiesUser", method = RequestMethod.GET)
    public ModelAndView showAllActivitiesUser() throws SQLException{
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_ALL_USER);
        List<TestPassingActivity> list = passingTestActivityService.getAll();
        Map<String, Integer> st = new LinkedHashMap<>();
        for(TestPassingActivity activity : list){
            if (activity.getContent().getItems() != null)
                st.put(activity.getActivity().getName(), activity.getActivity().getId());
        }
        modelAndView.addObject("activities", st);
        return modelAndView;
    }

    /**
     * delete selected activity
     *
     * @param id            id selected activity
     * @return              page with all test activities
     * @throws              SQLException
     */
    @RequestMapping(value = "/deletePassingActivity", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam(required = true) Integer id ) throws SQLException {
        passingTestActivityService.delete(passingTestActivityService.getById(id));
        return "redirect:/activities";
//        return "redirect:/passingActivities";
    }

    /**
     * select author or user rights
     *
     * @return              page with bottoms
     */
    @RequestMapping(value = "/authorOrUser", method = RequestMethod.GET)
    public ModelAndView chooseAuthorOrUser(){
        return new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_AUTHOR_OR_USER);
    }

    /**
     * show page for add question with answers
     *
     * @param request       it must be to get user from session
     * @param id            id selected activity
     * @return              page for create question with answers
     * @throws              SQLException
     */
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

    /**
     * create question with answers
     *
     * @param dto               object with parameters
     * @param id                id selected activity
     * @param numberQuestion    question's number
     * @return                  activity's page or page for edit question with answers (if during the creation of question has not been selected no one correct answer)
     * @throws                  SQLException
     */
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(@ModelAttribute("ptaDto")PassingTestActivityDto dto, @RequestParam(required = true) Integer id,
                              @RequestParam(required = false) Integer numberQuestion) throws SQLException{

        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> data = content.getItems();
        if (data == null){
            data = new ArrayList<>();
        }

        AnswerTestQuestion answer1 = new AnswerTestQuestion();
        answer1.setAnswer(dto.getAnswer1());
        answer1.setRightAnswer(dto.getRightAnswer1());
        AnswerTestQuestion answer2 = new AnswerTestQuestion();
        answer2.setAnswer(dto.getAnswer2());
        answer2.setRightAnswer(dto.getRightAnswer2());
        AnswerTestQuestion answer3 = new AnswerTestQuestion();
        answer3.setAnswer(dto.getAnswer3());
        answer3.setRightAnswer(dto.getRightAnswer3());
        AnswerTestQuestion answer4 = new AnswerTestQuestion();
        answer4.setAnswer(dto.getAnswer4());
        answer4.setRightAnswer(dto.getRightAnswer4());
        List<AnswerTestQuestion> list = new ArrayList<>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
        list.add(answer4);

        AnswersTestQuestion answersTestQuestion = new AnswersTestQuestion();
        answersTestQuestion.setAnswers(list);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (list.get(i).getRightAnswer() != null && !list.get(i).getRightAnswer().equals("")) {
                count++;
            }
        }
        if (count > 0) {
            answersTestQuestion.setRightCountAnswers(count);
            PassingTestData testData = new PassingTestData();
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
            ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW);

            modelAndView.addObject("passingActivity", passingActivity);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD_QUESTION);
            modelAndView.addObject("ptaDto", dto);
            modelAndView.addObject("passingActivity", passingActivity);
            modelAndView.addObject("numberQuestion", numberQuestion);
            modelAndView.addObject("warnMessage", "Вы не отметили ни одного верного ответа!");
            return modelAndView;
        }
    }

    /**
     * edit selected question
     *
     * @param request           it must be to get user from session
     * @param id                id selected activity
     * @param numberQuestion    number of the selected question
     * @return                  page for edit question and answers
     * @throws                  SQLException
     */
    @RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
    public ModelAndView editQuestion(HttpServletRequest request, @RequestParam(required = false) Integer id,
                                     @RequestParam(required = false) Integer numberQuestion) throws SQLException{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_ADD_QUESTION);
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
        PassingTestData item = list.get(numberQuestion - 1);
        PassingTestActivityDto dto = new PassingTestActivityDto();
        dto.setQuestion(item.getQuestion());
        List<AnswerTestQuestion> list1 = item.getAnswers().getAnswers();
        dto.setAnswer1(list1.get(0).getAnswer());
        dto.setReturnRightAnswer1(list1.get(0).getRightAnswer());
        dto.setAnswer2(list1.get(1).getAnswer());
        dto.setReturnRightAnswer2(list1.get(1).getRightAnswer());
        dto.setAnswer3(list1.get(2).getAnswer());
        dto.setReturnRightAnswer3(list1.get(2).getRightAnswer());
        dto.setAnswer4(list1.get(3).getAnswer());
        dto.setReturnRightAnswer4(list1.get(3).getRightAnswer());
        modelAndView.addObject("ptaDto", dto);
        modelAndView.addObject("passingActivity", passingActivity);
        modelAndView.addObject("numberQuestion", numberQuestion);
        return modelAndView;
    }

    /**
     * delete selected question
     *
     * @param numberQuestion    id of the selected question
     * @param id                id of the selected activity
     * @return                  activity's page with questions
     * @throws                  SQLException
     */
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public String deleteQuestion(@RequestParam(required = false) Integer numberQuestion, @RequestParam(required = false) Integer id) throws SQLException{
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
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

    /**
     * passing test and show result
     *
     * @param dto               object with parameters
     * @param id                id of the selected activity
     * @param numberQuestion    number of the selected question
     * @param test              indication that user answered
     * @return                  show each question in the test and than show a result
     * @throws                  SQLException
     */
    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public ModelAndView test(@ModelAttribute("ptaDto")PassingTestActivityDto dto,
            @RequestParam(required = false) Integer id,
                                     @RequestParam(required = false) Integer numberQuestion,
                                     @RequestParam(required = false) Integer test) throws SQLException {
        ModelAndView modelAndView;
        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();

        if (test != null && test == 2) {
            for (PassingTestData aList : list) {
                numberQuestion = aList.getNumberQuestion();
                answer(dto, id, numberQuestion);
            }
            numberQuestion = null;
        }

        if(numberQuestion == null){
            numberQuestion = 1;
        }
        if (test != null && test == 1){
            answer(dto, id, numberQuestion);
            numberQuestion += test;
        }
        if (numberQuestion <= list.size())
        {
            PassingTestData item = list.get(numberQuestion - 1);
            dto = new PassingTestActivityDto();
            dto.setQuestion(item.getQuestion());
            List<AnswerTestQuestion> list1 = item.getAnswers().getAnswers();
            dto.setAnswer1(list1.get(0).getAnswer());
            dto.setAnswer2(list1.get(1).getAnswer());
            dto.setAnswer3(list1.get(2).getAnswer());
            dto.setAnswer4(list1.get(3).getAnswer());
            if (item.getAnswers().getRightCountAnswers() == 1) {
                modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_RADIO_QUESTION);

            } else {
                modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_SHOW_CHECKBOX_QUESTION);

            }
            modelAndView.addObject("ptaDto", dto);
            modelAndView.addObject("passingActivity", passingActivity);
            modelAndView.addObject("numberQuestion", numberQuestion);
        } else {
            modelAndView = result(id);

        }
        return modelAndView;
    }

    /**
     * save selected answers during the test
     *
     * @param dto               object with parameters
     * @param id                id of the 5selected activity
     * @param numberQuestion    number of the selected question
     * @throws                  SQLException
     */
    public void answer (PassingTestActivityDto dto, Integer id, Integer numberQuestion) throws SQLException {

        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
        PassingTestData data = list.get(numberQuestion - 1);
        AnswersTestQuestion answers = data.getAnswers();
        List<AnswerTestQuestion> listAnswer = answers.getAnswers();
        AnswerTestQuestion answerTestQuestion = listAnswer.get(0);
        answerTestQuestion.setRightAnswerUser(dto.getRightAnswer1());
        System.out.println(dto.getRightAnswer1());
        listAnswer.set(0, answerTestQuestion);
        listAnswer.get(1).setRightAnswerUser(dto.getRightAnswer2());
        listAnswer.get(2).setRightAnswerUser(dto.getRightAnswer3());
        listAnswer.get(3).setRightAnswerUser(dto.getRightAnswer4());
       answers.setAnswers(listAnswer);
        data.setAnswers(answers);
        list.set(numberQuestion - 1, data);
        content.setItems(list);
        passingActivity.setContent(content);
        passingTestActivityService.update(passingActivity);
    }

    /**
     * show result after passing test
     *
     * @param id                id of the 5selected activity
     * @return                  result's page
     * @throws                  SQLException
     */
    @RequestMapping(value = "/resultTest", method = RequestMethod.GET)
    public ModelAndView result(@RequestParam(required = false) Integer id) throws SQLException {

        TestPassingActivity passingActivity = passingTestActivityService.getById(id);
        TestPassingActivityContent content = passingActivity.getContent();
        List<PassingTestData> list = content.getItems();
         int numberQuestion = list.size();
        ModelAndView modelAndView = new ModelAndView(JspPath.PASSING_TEST_ACTIVITY_RESULT);
        int rightAns = 0;
        list = passingTestActivityService.getById(id).getContent().getItems();
        for (PassingTestData aList : list) {
            int countRightAns = 0;
            if (aList.getAnswers().getRightCountAnswers() != 0) {
                List<AnswerTestQuestion> answerTestQuestions = aList.getAnswers().getAnswers();
                for (AnswerTestQuestion answerTestQuestion : answerTestQuestions) {
                    if (answerTestQuestion.getRightAnswer() == null && answerTestQuestion.getRightAnswerUser() == null ||
                            answerTestQuestion.getRightAnswer() != null && answerTestQuestion.getRightAnswerUser() != null) {
                        countRightAns++;
                    }
                }
                if (countRightAns == 4) {
                    rightAns++;
                }
            }

        }
        modelAndView.addObject("result", rightAns);
        String conclusion;
        if(rightAns == 0){
            conclusion = "Вы не ответили ни на один вопрос!";
        } else if (rightAns*100/(numberQuestion) < 80){
            conclusion = "Вы не прошли тест! Попробуйте еще раз!";
        } else {
            conclusion = "Вы прошли тест! Поздравляем!!!";
        }
        modelAndView.addObject("conclusion", conclusion);
        modelAndView.addObject("numberQuestion", numberQuestion);

    return modelAndView;
    }

}