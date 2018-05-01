package ru.lvlp.timetable.contoller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDeniedGet(Model model){

        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(value = "logout", required = false) String logout ) {
        if (logout != null) {
            model.addAttribute("message", "Logged out from timetable successfully.");
        }

        return "login";
    }
}
