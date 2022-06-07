package A4.G2.controller;

import A4.G2.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("loginStatus")
public class ArtDetailsController {
	@RequestMapping(value="/art-details", method = RequestMethod.GET)
	public String showArtDetailsPage(ModelMap model) {
		model.put("loginStatus", "Not logged in");
		return "art-details";
	}

	@RequestMapping(value="/art-details", method = RequestMethod.POST)
	public String registeredUser(ModelMap model){
		User user = new User("LoggedUserName", "placeholder_password", "placeholder_email", "placeholder_email",
				"placeholder_address", new Date(1990, 6, 3));
		model.put("loginStatus", user.getUsername());
		return "art-details";
	}

}

