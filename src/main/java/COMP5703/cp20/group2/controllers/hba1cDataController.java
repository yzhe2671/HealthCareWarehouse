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
public class hba1cDataController {
	
	@Autowired
	drugMapper mapper;
	
	@RequestMapping(value="/chartdata/Ahba1c1-3", method=RequestMethod.GET)
	public void Ahba1c1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectAhba1c0_1_3(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectAhba1c3_1_3(username),mapper.selecthba1c3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ahba1c3-7", method=RequestMethod.GET)
	public void Ahba1c3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectAhba1c0_3_7(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectAhba1c3_3_7(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectAhba1c12_3_7(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Ahba1c7-12", method=RequestMethod.GET)
	public void Ahba1c7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectAhba1c0_7_12(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectAhba1c3_7_12(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectAhba1c12_7_12(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Whba1c1-3", method=RequestMethod.GET)
	public void Whba1c1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectWhba1c0_1_3(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectWhba1c3_1_3(username),mapper.selecthba1c3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Whba1c3-7", method=RequestMethod.GET)
	public void Whba1c3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectWhba1c0_3_7(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectWhba1c3_3_7(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectWhba1c12_3_7(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Whba1c7-12", method=RequestMethod.GET)
	public void Whba1c7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectWhba1c0_7_12(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectWhba1c3_7_12(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectWhba1c12_7_12(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Chba1c1-3", method=RequestMethod.GET)
	public void Chba1c1_3(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectChba1c0_1_3(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectChba1c3_1_3(username),mapper.selecthba1c3(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Chba1c3-7", method=RequestMethod.GET)
	public void Chba1c3_7(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectChba1c0_3_7(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectChba1c3_3_7(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectChba1c12_3_7(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	@RequestMapping(value="/chartdata/Chba1c7-12", method=RequestMethod.GET)
	public void Chba1c7_12(HttpServletResponse response, HttpSession session) throws IOException{
		String username = session.getAttribute("login").toString();
		
		List<twoindicatorDouble> resultlist=new ArrayList<twoindicatorDouble>();
		
		resultlist.add(new twoindicatorDouble("HBA1C at admission test",mapper.selectChba1c0_7_12(username),mapper.selecthba1c0(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 3 month",mapper.selectChba1c3_7_12(username),mapper.selecthba1c3(username)));
		resultlist.add(new twoindicatorDouble("HBA1C at 12 month",mapper.selectChba1c12_7_12(username),mapper.selecthba1c12(username)));
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(resultlist));
	}
	
	

	
	
}
