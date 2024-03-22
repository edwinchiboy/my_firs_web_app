package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class WelcomeController {

//    public LoginController(final AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    private AuthenticationService authenticationService;
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @RequestMapping("login")
//    public String goToLoginPage(@RequestParam String name, ModelMap model) {
//        model.put("name", name);
////        logger.debug("Request param is ",  name);
////        logger.info("Request param is ",  name);
//
//        return "login";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());

        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      return   authentication.getName();
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model, HttpSession session) {
//
//
//        if (authenticationService.authenticate(name, password)) {
//            session.setAttribute("name", name);
//
//            model.put("name", name);
//            return "welcome";
//        }
//
//        model.put("errorMessage", "Invalid Credentials! Please try again");
//
//
//        return "login";
//    }
}
