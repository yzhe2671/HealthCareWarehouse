package COMP5703.cp20.group2.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import COMP5703.cp20.group2.domain.predictionmodel;
import COMP5703.cp20.group2.mapper.patientMapper;
import COMP5703.cp20.group2.service.predictManager;

@Controller
public class predictionController {
	
	@Autowired
	patientMapper mapper;
	
	@Autowired
	predictManager predictmanager;

	@RequestMapping(value="/prediction", method=RequestMethod.GET)
	public String prediction(ModelMap model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease= mapper.selectdisease(username);
		predictionmodel predict = new predictionmodel();
		
		model.put("username", username);
		model.put("disease", disease);
		model.put("predict", predict);
		return "prediction";
		
	}
	
	@RequestMapping(value="/predictionresult", method=RequestMethod.POST)
	public String predictionresult(@ModelAttribute("predict") predictionmodel predict, ModelMap model, HttpSession session) {
		if(session.getAttribute("login")==null) {
			return "login";
		}
		String username=session.getAttribute("login").toString();
		String disease= mapper.selectdisease(username).toLowerCase();
		
		int age = Calendar.getInstance().get(Calendar.YEAR)-predict.getYearofbirth();
		String gender;
		if(predict.getGender()=="Male") gender="M";
		else gender="F";
		String race=predict.getRace();
		String smoking = predict.getSmoking();
		String alcohol = predict.getAlcohol();
		String softdrink=predict.getSoftdrink();
		String exercise  =  predict.getExercise();
		
		String ifdisease= predictmanager.DiseasePredict(age, gender, race, smoking, alcohol, softdrink, exercise);
		
		model.put("username", username);
		model.put("disease", disease);
		System.out.println(ifdisease);
		if (ifdisease.equals("yes")){
			model.put("result", "high");
			model.put("advice", "Please let the patient be "
					+ "careful about lifestyle, negtive habit like smoking, "
					+ "alcohol and sodas should be given up while positive"
					+ "habit like exercise should be kept up.");
			}
		else if(ifdisease.equals("no")){
			model.put("result", "low");
			model.put("advice", "Fortunately the patient is unlikely to have the disease,"
					+ " however it is also needed to keep good lifestyle.");
			}
		else{
			model.put("result", "unkown");
			}
		
		return "predictionresult";
	}
}
