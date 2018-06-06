package COMP5703.cp20.group2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String newpage(HttpSession session, ModelMap model) {
		if (session.getAttribute("login")!=null) {
			model.put("username", session.getAttribute("login").toString());
			return "homepage_login";
		}else {
		return "homepage";
		}
	}

}

