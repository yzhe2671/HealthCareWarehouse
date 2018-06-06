package COMP5703.cp20.group2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.searchmodel.oneindicatorDouble;
import COMP5703.cp20.group2.domain.searchmodel.oneindicatorint;
import COMP5703.cp20.group2.mapper.patientMapper;

@Controller
public class patientcontroller {
	
	
	
	@Autowired
	private patientMapper mapper;
	
	private List<patient> patientlist;
	private int NoOfPatient;
	
	@RequestMapping(value="/featurelist", method=RequestMethod.GET)
	public String featurelist(@RequestParam(value="id", required = true) int iim_no, Model model) {
		patient patient = mapper.selectbyid(iim_no);
		if(!(patient==null)) {
			model.addAttribute("patientid", iim_no);
			return "featurelist";
		}
		else {
			return "nosuchpatient";
		}
			
		}
	
	
	
	
}


