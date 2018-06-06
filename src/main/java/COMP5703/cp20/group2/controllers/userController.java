package COMP5703.cp20.group2.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import COMP5703.cp20.group2.domain.user;
import COMP5703.cp20.group2.mapper.userMapper;

@Controller
public class userController {
	
	@Autowired
	private userMapper usermapper;
	
	
	@RequestMapping(value="/user/register", method=RequestMethod.GET)
	public String UserRegisteration(ModelMap model) {
		user user = new user();
		model.put("user", user);
		return "registeration";
	}
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public String UserCreation(@ModelAttribute("user") user user, ModelMap model, HttpSession session) {
		if (usermapper.checkexistence(user.getUsername())!=null||user.getUsername()==""||user.getUser_password()==""){
			model.put("error","This username has been registered");
			return "registeration";
		}else {
			System.out.println("user is created");
			usermapper.insertuser(user);
			session.setAttribute("login", user.getUsername());
			model.put("firstname", user.getFirstname());
			model.put("lastname", user.getLastname());
		return "register_success";
		}
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model,HttpSession session) {
		//get username and password from the html form
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//check if the password is correct
		if(usermapper.checkpassword(username, password)!=null) {
			//if password is correct, then add an attribute to this session as a mark
			// if password is incorrect, the user will be required input it again
			session.setAttribute("login", username);
			model.put("username", username);
			String referer=request.getHeader("Referer");
			System.out.print(referer);
			if (referer.toLowerCase().contains("user/login")) {
				return "homepage_login";
			}
			if(referer.toLowerCase().contains("/predict")) {
				return "redirect:/prediction";
			}
			return "redirect:"+referer;
		}else {
			model.put("error", "password is incorrect, please try again");
			return "login";
		}
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String userLogout(HttpSession session) {
		//once the user logged out, the maker in the session will be remove
		session.removeAttribute("login");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="user/existence", method=RequestMethod.GET)
	 public void Userexistence(@RequestParam(value="id", required=true) String username, 
			 HttpServletResponse response) throws Throwable {
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if(usermapper.checkexistence(username)!=null) {
		out.println(gson.toJson("exist"));}
		else {
			out.println(gson.toJson("notexist"));
		}
	}

}
