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
public class cholestDataController {
	
	@Autowired
	drugMapper mapper;
	
	@RequestMapping(value="/chartdata/Acholest1-3", method=RequestMethod.GET)
	public void Acholest1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectAcholest0_1_3(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectAcholest3_1_3(username),mapper.selectcholest3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Acholest3-7", method=RequestMethod.GET)
	public void Acholest3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectAcholest0_3_7(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectAcholest3_3_7(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectAcholest12_3_7(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Acholest7-12", method=RequestMethod.GET)
	public void Acholest7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectAcholest0_7_12(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectAcholest3_7_12(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectAcholest12_7_12(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wcholest1-3", method=RequestMethod.GET)
	public void Wcholest1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectWcholest0_1_3(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectWcholest3_1_3(username),mapper.selectcholest3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wcholest3-7", method=RequestMethod.GET)
	public void Wcholest3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectWcholest0_3_7(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectWcholest3_3_7(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectWcholest12_3_7(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wcholest7-12", method=RequestMethod.GET)
	public void Wcholest7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectWcholest0_7_12(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectWcholest3_7_12(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectWcholest12_7_12(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ccholest1-3", method=RequestMethod.GET)
	public void Ccholest1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectCcholest0_1_3(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectCcholest3_1_3(username),mapper.selectcholest3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ccholest3-7", method=RequestMethod.GET)
	public void Ccholest3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectCcholest0_3_7(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectCcholest3_3_7(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectCcholest12_3_7(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ccholest7-12", method=RequestMethod.GET)
	public void Ccholest7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("cholest at admission test",mapper.selectCcholest0_7_12(username),mapper.selectcholest0(username)));
		resultlist.add(new twoindicatorDouble("cholest at 3 month",mapper.selectCcholest3_7_12(username),mapper.selectcholest3(username)));
		resultlist.add(new twoindicatorDouble("cholest at 12 month",mapper.selectCcholest12_7_12(username),mapper.selectcholest12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	

	
	
}

