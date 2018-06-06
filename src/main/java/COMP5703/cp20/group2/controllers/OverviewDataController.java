package COMP5703.cp20.group2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import COMP5703.cp20.group2.domain.searchmodel.oneIndicatorAndoneStyle;
import COMP5703.cp20.group2.domain.searchmodel.oneindicatorDouble;
import COMP5703.cp20.group2.domain.searchmodel.oneindicatorint;
import COMP5703.cp20.group2.mapper.patientMapper;

@Controller
public class OverviewDataController {
	
	@Autowired
	patientMapper mapper;
	
	@RequestMapping(value="/agegroup", method=RequestMethod.GET)
	public void agegroup(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		List<oneindicatorint> age= new ArrayList<oneindicatorint>();
		age.add(new oneindicatorint("60-70",mapper.agefrom60_70(username)));
		age.add(new oneindicatorint("70-80",mapper.agefrom70_80(username)));
		age.add(new oneindicatorint("80-90",mapper.agefrom80_90(username)));
		age.add(new oneindicatorint("90-100",mapper.agefrom90_100(username)));
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(age));
		
		
	}
	
	@RequestMapping(value="/gendergroup", method=RequestMethod.GET)
	public void gendergroup(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		List<oneIndicatorAndoneStyle> gender= new ArrayList<oneIndicatorAndoneStyle>();
		gender.add(new oneIndicatorAndoneStyle("Male",mapper.selectmale(username),"color:#1E90FF"));
		gender.add(new oneIndicatorAndoneStyle("Female",mapper.selectfemale(username),"color:#FF4500"));
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(gender));
	}
	
	

	@RequestMapping(value="/averageHDL", method=RequestMethod.GET)
	public void HBcheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<oneindicatorDouble> testvalue= new ArrayList<oneindicatorDouble>();
		testvalue.add(new oneindicatorDouble("HDL at 0 month",mapper.HDL0selection()));
		testvalue.add(new oneindicatorDouble("HDL at 3 month",mapper.HDL3selection()));
		testvalue.add(new oneindicatorDouble("HDL at 12 month",mapper.HDL12selection()));
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(testvalue));
		
		}
	
	@RequestMapping(value="/racegroup", method=RequestMethod.GET)
	public void racegroup(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username= session.getAttribute("login").toString();
		List <oneindicatorint> racelist = new ArrayList<oneindicatorint>();
		racelist.add(new oneindicatorint("China",mapper.selectChinese(username)));
		racelist.add(new oneindicatorint("Australia",mapper.selectAustralian(username)));
		racelist.add(new oneindicatorint("Russia",mapper.selectRussian(username)));
		racelist.add(new oneindicatorint("Japan",mapper.selectJapanese(username)));
		racelist.add(new oneindicatorint("Korea",mapper.selectKorean(username)));
		racelist.add(new oneindicatorint("India",mapper.selectIndian(username)));




		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(racelist));
		
		}
	

}
