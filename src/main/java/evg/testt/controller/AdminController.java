package evg.testt.controller;

import evg.testt.MailMail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

//    MailMail mailMail;

    @RequestMapping(name = "/mail", method = RequestMethod.GET)
    public void sendMail(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Mail.xml");

        MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("from@no-spam.com",
                "lugovoy.misha@gmail.com",
                "Testing123",
                "Testing only \n\n Hello Spring Email Sender");
    }



}
