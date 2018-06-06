package COMP5703.cp20.group2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import COMP5703.cp20.group2.domain.searchmodel.twoindicatorDouble;
import COMP5703.cp20.group2.mapper.drugMapper;

@Controller
public class glucoseDataController {
	
	@Autowired
	drugMapper mapper;
	
	@RequestMapping(value="/chartdata/Aglucose1-3", method=RequestMethod.GET)
	public void Aglucose1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectAglucose0_1_3(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectAglucose3_1_3(username),mapper.selectglucose3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Aglucose3-7", method=RequestMethod.GET)
	public void Aglucose3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectAglucose0_3_7(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectAglucose3_3_7(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectAglucose12_3_7(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Aglucose7-12", method=RequestMethod.GET)
	public void Aglucose7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectAglucose0_7_12(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectAglucose3_7_12(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectAglucose12_7_12(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wglucose1-3", method=RequestMethod.GET)
	public void Wglucose1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectWglucose0_1_3(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectWglucose3_1_3(username),mapper.selectglucose3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wglucose3-7", method=RequestMethod.GET)
	public void Wglucose3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectWglucose0_3_7(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectWglucose3_3_7(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectWglucose12_3_7(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wglucose7-12", method=RequestMethod.GET)
	public void Wglucose7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectWglucose0_7_12(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectWglucose3_7_12(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectWglucose12_7_12(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Cglucose1-3", method=RequestMethod.GET)
	public void Cglucose1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectChba1c0_1_3(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectChba1c3_1_3(username),mapper.selectglucose3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Cglucose3-7", method=RequestMethod.GET)
	public void Cglucose3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectCglucose0_3_7(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectCglucose3_3_7(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectCglucose12_3_7(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Cglucose7-12", method=RequestMethod.GET)
	public void Cglucose7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("Glucose at admission test",mapper.selectCglucose0_7_12(username),mapper.selectglucose0(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 3 month",mapper.selectCglucose3_7_12(username),mapper.selectglucose3(username)));
		resultlist.add(new twoindicatorDouble("Glucose at 12 month",mapper.selectCglucose12_7_12(username),mapper.selectglucose12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist)); 
	}
	
	

	
	
}

