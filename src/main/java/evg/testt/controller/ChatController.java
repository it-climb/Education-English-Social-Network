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

    private ModelAndView chatPage(HttpServletRequest request, String jspPath) throws SQLException {
        List<Chat> chat = chatService.getAll();
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(jspPath);
        modelAndView.addObject("users", userService.getAll());
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("chat", chat);
        return modelAndView;
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        return chatPage(request, JspPath.CHAT_ALL);
    }

    @RequestMapping(value = "/writeTo", method = RequestMethod.GET)
    public ModelAndView writeTo(@RequestParam(required = true) String email, HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = chatPage(request, JspPath.CHAT_ALL);
        modelAndView.addObject("receiver", email);
        return modelAndView;
    }

    @RequestMapping(value = "/chatAdd", method = RequestMethod.POST)
    public String showAll(/*@ModelAttribute Chat chat,*/@RequestParam(required = true) String email,@RequestParam(required = false) String receiver, @RequestParam(required = true) String message, @RequestParam(required = false) boolean is121) throws SQLException {
        User user = userService.getByEmail(email);
        Chat chat = Chat.newBuilder().setUser(user).setMessage(message).build();
        if (receiver == "" || receiver == null) {
            chatService.insert(chat);
        } else {
            chat.setReceiver(receiver);
            chatService.insert(chat);
        }
        if (is121 == true) {
            return "redirect:/messages";
        }else{
            return "redirect:/chat";
        }
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView show121/*show one to one*/(HttpServletRequest request,@RequestParam(required = true) String email) throws SQLException {
        ModelAndView modelAndView = chatPage(request, JspPath.MESSAGES);
        modelAndView.addObject("receiver", email);
        return modelAndView;
    }
}
