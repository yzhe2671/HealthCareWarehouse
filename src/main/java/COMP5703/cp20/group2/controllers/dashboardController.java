package COMP5703.cp20.group2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import COMP5703.cp20.group2.mapper.patientMapper;
import COMP5703.cp20.group2.mapper.userMapper;

@Controller
public class dashboardController {
	
	@Autowired
	userMapper usermapper;
	
	@Autowired
	patientMapper mapper;

	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String gotoDashboard(HttpSession session, ModelMap model) {
		//when someone request to go to dashboard, the program will check their session
		//if session has the marker, the user will be identified as logged in already
		//otherwise the user will be sent to log in page and required to input password
		if (session.getAttribute("login")!=null) {
		String username = session.getAttribute("login").toString();
		model.put("username", username);
		 if(usermapper.checkpatientnumber(username)==0) {
			 return "shikaiupload";
		 }else {
			return "redirect:/patientoverview";
			}
		}else {
		return "login";
		}
	}
	
	@RequestMapping(value="/dashboardtest")
	public String dashboardtest() {
		return "dashboard1";
	}
	
	@RequestMapping(value="/patientoverview", method=RequestMethod.GET)
	public String patientoverview(Model model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease= mapper.selectdisease(username);
		int countnumber = mapper.countPatientNo(username);
		Double strokepercentage= (mapper.strokepatient(username)*100.0f)/countnumber;
		String percentageformat= String.format("%.1f", strokepercentage);
		Double averageAge=mapper.averageAge(username);
		int roundAge;
		if(averageAge!=null) {
		roundAge =  (int) Math.round(averageAge);
		model.addAttribute("age",roundAge);}
		else {
		model.addAttribute("age", averageAge);
		}
		model.addAttribute("disease", disease);
		model.addAttribute("number", countnumber);
		model.addAttribute("strokepercentage",percentageformat);
		model.addAttribute("username",username);

		return "dashboard1";
	}
	
	
	@RequestMapping(value="/habitanalysis", method=RequestMethod.GET)
	public String habitanalysis(ModelMap model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease=mapper.selectdisease(username);
		model.put("username", username);
		model.put("disease", disease);
		return "habitanalysis1";
	}
	
	@RequestMapping(value="/advancedhabitanalysis", method=RequestMethod.GET)
	public String advancedhabitanalysis(ModelMap model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease=mapper.selectdisease(username);
		model.put("username", username);
		model.put("disease", disease);
		return "advancedhabitanalysis1";
	}
	
	@RequestMapping(value="/druganalysis", method=RequestMethod.GET)
	public String druganalysis(ModelMap model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease=mapper.selectdisease(username);
		model.put("username", username);
		model.put("disease", disease);
		return "druganalysis1";
	}
}
