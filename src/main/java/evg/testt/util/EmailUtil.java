package evg.testt.util;

import evg.testt.model.User;
import evg.testt.controller.UserController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;


public class EmailUtil {

    public ModelAndView qqqq(HttpServletRequest request) throws SQLException {
        HttpSession  session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView aaa = null;
        aaa.addObject("email",sessionUser.getEmail());
        return aaa;
    }
}
