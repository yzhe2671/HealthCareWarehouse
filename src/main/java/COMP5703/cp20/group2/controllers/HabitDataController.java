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

import com.google.gson.Gson;

import COMP5703.cp20.group2.domain.searchmodel.oneindicatorint;
import COMP5703.cp20.group2.domain.searchmodel.twoindicatorAndoneStyle;
import COMP5703.cp20.group2.domain.searchmodel.twoindicatorDouble;
import COMP5703.cp20.group2.mapper.habitMapper;
import COMP5703.cp20.group2.mapper.patientMapper;

@Controller
public class HabitDataController {
	
	@Autowired
	habitMapper mapper;
	
	@Autowired
	patientMapper patientmapper;
	
	
	//----------------------send smoking response to AJAX
	@RequestMapping(value="/chartdata/smoking", method=RequestMethod.GET)
	public void smoking(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username= session.getAttribute("login").toString();
		Double smokingstrokepercentage = (double) Math.round(mapper.countsmokingstroke(username)*100.0f/mapper.countsmoking(username));
		Double smokingnonstrokepercentage = (double) Math.round(mapper.countsmokingnonstroke(username)*100.0f/mapper.countsmoking(username));
		Double nonsmokingstrokepercentage = (double) Math.round(mapper.countnonsmokingstroke(username)*100.0f/mapper.countnonsmoking(username));
		Double nonsmokingnonstrokepercentage=  (double) Math.round(mapper.countnonsmokingnonstroke(username)*100.0f/mapper.countnonsmoking(username));
		
		List <twoindicatorDouble> smokinglist = new ArrayList<twoindicatorDouble>();
		smokinglist.add(new twoindicatorDouble("Smoking Patient",smokingstrokepercentage,smokingnonstrokepercentage));
		smokinglist.add(new twoindicatorDouble("Non-smoking Patient",nonsmokingstrokepercentage,nonsmokingnonstrokepercentage));

		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(smokinglist));
		
		}
	
	//----------------------send alcohol response to AJAX
	@RequestMapping(value="/chartdata/alcohol", method=RequestMethod.GET)
	public void alcohol(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username= session.getAttribute("login").toString();
		Double alcoholstrokepercentage = (double) Math.round(mapper.countalcoholstroke(username)*100.0f/mapper.countalcohol(username));
		Double alcoholnonstrokepercentage = (double) Math.round(mapper.countalcoholnonstroke(username)*100.0f/mapper.countalcohol(username));
		Double nonalcoholstrokepercentage = (double) Math.round(mapper.countnonalcoholstroke(username)*100.0f/mapper.countnonalcohol(username));
		Double nonalcoholnonstrokepercentage=  (double) Math.round(mapper.countnonalcoholnonstroke(username)*100.0f/mapper.countnonalcohol(username));
		
		List <twoindicatorDouble> smokinglist = new ArrayList<twoindicatorDouble>();
		smokinglist.add(new twoindicatorDouble("Drinker",alcoholstrokepercentage,alcoholnonstrokepercentage));
		smokinglist.add(new twoindicatorDouble("Non-drinker",nonalcoholstrokepercentage,nonalcoholnonstrokepercentage));

		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(smokinglist));
		
		}
	
	//---------------------------send softdrink response to AJAX
	@RequestMapping(value="/chartdata/softdrink", method=RequestMethod.GET)
	public void softdrink(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username= session.getAttribute("login").toString();
		Double softdrinkstrokepercentage = (double) Math.round(mapper.countsoftdrinkstroke(username)*100.0f/mapper.countsoftdrink(username));
		Double softdrinknonstrokepercentage = (double) Math.round(mapper.countsoftdrinknonstroke(username)*100.0f/mapper.countsoftdrink(username));
		Double nonsoftdrinkstrokepercentage = (double) Math.round(mapper.countnonsoftdrinkstroke(username)*100.0f/mapper.countnonsoftdrink(username));
		Double nonsoftdrinknonstrokepercentage=  (double) Math.round(mapper.countnonsoftdrinknonstroke(username)*100.0f/mapper.countnonsoftdrink(username));
		
		List <twoindicatorDouble> smokinglist = new ArrayList<twoindicatorDouble>();
		smokinglist.add(new twoindicatorDouble("patient with sodas-drinking",softdrinkstrokepercentage,softdrinknonstrokepercentage));
		smokinglist.add(new twoindicatorDouble("patient without sodas-drinking",nonsoftdrinkstrokepercentage,nonsoftdrinknonstrokepercentage));

		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(smokinglist));
		
		}
	
	
	//---------------------------send exercise response to AJAX
	@RequestMapping(value="/chartdata/exercise", method=RequestMethod.GET)
	public void exercise(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username= session.getAttribute("login").toString();
		Double exercisestrokepercentage = (double) Math.round(mapper.countexercisestroke(username)*100.0f/mapper.countexercise(username));
		Double exercisenonstrokepercentage = (double) Math.round(mapper.countexercisenonstroke(username)*100.0f/mapper.countexercise(username));
		Double nonexercisestrokepercentage = (double) Math.round(mapper.countnonexercisestroke(username)*100.0f/mapper.countnonexercise(username));
		Double nonexercisenonstrokepercentage=  (double) Math.round(mapper.countnonexercisenonstroke(username)*100.0f/mapper.countnonexercise(username));
		
		List <twoindicatorDouble> smokinglist = new ArrayList<twoindicatorDouble>();
		smokinglist.add(new twoindicatorDouble("Patient with exercise",exercisestrokepercentage,exercisenonstrokepercentage));
		smokinglist.add(new twoindicatorDouble("Patient without exercise",nonexercisestrokepercentage,nonexercisenonstrokepercentage));

		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(smokinglist));
		
		}
	
	
	@RequestMapping(value="/chartdata/strokepercentagepiechart", method=RequestMethod.GET)
	public void percentageallpatient(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countstrokepatient(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.counttotalpatient(username)-mapper.countstrokepatient(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/smokingpercentagepiechart", method=RequestMethod.GET)
	public void smokingpercentagepiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countsmokingstroke(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countsmokingnonstroke(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/drinkingpercentagepiechart", method=RequestMethod.GET)
	public void drinkingpercentagepiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countalcoholstroke(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countalcoholnonstroke(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/softdrinkpercentagepiechart", method=RequestMethod.GET)
	public void softdrinkpercentagepiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countsoftdrinkstroke(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countsoftdrinknonstroke(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/smokingdrinkingpiechart", method=RequestMethod.GET)
	public void smokingdrinkingpiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countsmokingdrinking(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countsmokingdrinkingnon(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/drinkingsodaspiechart", method=RequestMethod.GET)
	public void drinkingsodaspiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countdrinkingsodas(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countdrinkingsodasnon(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/smokingsodaspiechart", method=RequestMethod.GET)
	public void smokingsodaspiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countsmokingsodas(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countsmokingsodasnon(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}
	
	@RequestMapping(value="/chartdata/smokingdrinkingsodaspiechart", method=RequestMethod.GET)
	public void smokingdrinkingsodaspiechart(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		String username=session.getAttribute("login").toString();
		String disease=patientmapper.selectdisease(username);
		List<oneindicatorint> strokelist=new ArrayList<oneindicatorint>();
		strokelist.add(new oneindicatorint("Number of "+disease+" patient",mapper.countsmokingdrinkingsodas(username)));
		strokelist.add(new oneindicatorint("Number of non-"+disease+" patient",mapper.countsmokingdrinkingsodasnon(username)));

		
		Gson gson=new Gson();
		response.setContentType("application/json");
		PrintWriter out= response.getWriter();
		out.println(gson.toJson(strokelist));
		
		
	}

}
