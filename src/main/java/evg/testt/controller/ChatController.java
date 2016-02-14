package evg.testt.controller;

import evg.testt.model.Chat;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.User;
import evg.testt.service.ChatService;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.service.UserService;
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
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    @Autowired
    UserService userService;

    /**
     * this model uses in another methods to not copy code
     *
     * @param request it must be to get user from session
     * @param jspPath it's path of your jsp page
     * @return
     * @throws SQLException
     */
    private ModelAndView chatPage(HttpServletRequest request, String jspPath) throws SQLException {
        List<Chat> chat = chatService.getAll();
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            ModelAndView modelAndView = new ModelAndView(JspPath.ISE_ERROR_VIEW);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView(jspPath);
        modelAndView.addObject("users", userService.getAll());
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("chat", chat);
        return modelAndView;
    }

    /**
     * show chat
     *
     * @param request it must be to get user from session
     * @return chatPage with JspPath.CHAT_ALL
     * @throws SQLException
     */
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        return chatPage(request, JspPath.CHAT_ALL);
    }

    /**
     * writeTo method that used to write someone in chat for all
     *
     * @param recEmail it's receiver's email
     * @param request it must be to get user from session
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/writeTo", method = RequestMethod.GET)
    public ModelAndView writeTo(@RequestParam(required = true) String recEmail, HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = chatPage(request, JspPath.CHAT_ALL);
        modelAndView.addObject("receiver", recEmail);
        return modelAndView;
    }

    /**
     * this code add messages in chat
     *
     * @param email yours email
     * @param recEmail receiver's email
     * @param message
     * @param is121 (is one to one) it's boolean that shows your page
     * @param request it must be to get user from session
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/chatAdd", method = RequestMethod.POST)
    public ModelAndView showAll(/*@ModelAttribute Chat chat,*/
                                @RequestParam(required = true) String email,
                                @RequestParam(required = false) String recEmail,
                                @RequestParam(required = true) String message,
                                @RequestParam(required = false) boolean is121,
                                HttpServletRequest request) throws SQLException {
        User user = userService.getByEmail(email);
        if (recEmail == ""){
            recEmail = null;
        }
        Chat chat = Chat.newBuilder().setUser(user).setMessage(message).setReceiver(recEmail).build();
        chatService.insert(chat);
        if(is121 == true){
            ModelAndView modelAndView = chatPage(request, JspPath.MESSAGES);
            modelAndView.addObject("receiver", recEmail);
            return modelAndView;
        }else{
            ModelAndView modelAndView = chatPage(request, JspPath.CHAT_ALL);
            modelAndView.addObject("receiver", recEmail);
            return modelAndView;
        }
        /*if (is121 == true) {
            return "redirect:/messages";
        }else{
            return "redirect:/chat";
        }*/
    }

    /**
     * show 121 messages
     *
     * @param request it must be to get user from session
     * @param recEmail receivers email
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView show121/*show one to one*/(HttpServletRequest request,@RequestParam(required = false) String recEmail) throws SQLException {
        ModelAndView modelAndView = chatPage(request, JspPath.MESSAGES);
        modelAndView.addObject("receiver", recEmail);
        return modelAndView;
    }
}
