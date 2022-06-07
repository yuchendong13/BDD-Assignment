package A4.G2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedInUser")
public class HomePageController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String indexHomePage(ModelMap model) {
        if (model.get("loggedInUser") == null) {
            model.put("loggedInUser", "");
        }
        return "home";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        if (model.get("loggedInUser") == null) {
            model.put("loggedInUser", "");
        }
        return "home";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.put("loggedInUser", "");
        return "home";
    }
}
