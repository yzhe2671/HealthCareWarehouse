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
public class triDataController { 
	
	@Autowired
	drugMapper mapper;
	
	@RequestMapping(value="/chartdata/Atri1-3", method=RequestMethod.GET)
	public void Atri1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectAtri0_1_3(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectAtri3_1_3(username),mapper.selecttri3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Atri3-7", method=RequestMethod.GET)
	public void Atri3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectAtri0_3_7(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectAtri3_3_7(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectAtri12_3_7(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Atri7-12", method=RequestMethod.GET)
	public void Atri7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectAtri0_7_12(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectAtri3_7_12(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectAtri12_7_12(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wtri1-3", method=RequestMethod.GET)
	public void Wtri1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectWtri0_1_3(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectWtri3_1_3(username),mapper.selecttri3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wtri3-7", method=RequestMethod.GET)
	public void Wtri3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectWtri0_3_7(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectWtri3_3_7(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectWtri12_3_7(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Wtri7-12", method=RequestMethod.GET)
	public void Wtri7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectWtri0_7_12(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectWtri3_7_12(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectWtri12_7_12(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ctri1-3", method=RequestMethod.GET)
	public void Ctri1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectCtri0_1_3(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectCtri3_1_3(username),mapper.selecttri3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ctri3-7", method=RequestMethod.GET)
	public void Ctri3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectCtri0_3_7(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectCtri3_3_7(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectCtri12_3_7(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ctri7-12", method=RequestMethod.GET)
	public void Ctri7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("TRI at admission test",mapper.selectCtri0_7_12(username),mapper.selecttri0(username)));
		resultlist.add(new twoindicatorDouble("TRI at 3 month",mapper.selectCtri3_7_12(username),mapper.selecttri3(username)));
		resultlist.add(new twoindicatorDouble("TRI at 12 month",mapper.selectCtri12_7_12(username),mapper.selecttri12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	

	
	
}

