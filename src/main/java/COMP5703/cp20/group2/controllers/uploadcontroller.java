package COMP5703.cp20.group2.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import COMP5703.cp20.group2.domain.drugusage;
import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.stroke_lab;
import COMP5703.cp20.group2.mapper.insertMapper;
import COMP5703.cp20.group2.mapper.patientMapper;
import COMP5703.cp20.group2.service.uploadManager;

@Controller
public class uploadcontroller {
	
	@Autowired
	uploadManager uploadmanager;
	

	
	@Autowired
	patientMapper patientmapper;
	
	@RequestMapping(value="/fileform", method=RequestMethod.GET)
	public String fileform() {
		return "fileupload";
	}
	
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String readfile(@RequestParam(value="file") MultipartFile file,
			@RequestParam(value="disease") String disease, HttpSession session, ModelMap model) 
					throws IllegalStateException, IOException {
		if(session.getAttribute("login")==null) {
			 return "login";
		 }
		try {
		 String username = session.getAttribute("login").toString();
		 uploadmanager.readfile(file,username,disease);
		}catch(Exception e){
			model.put("error", "The file you upload is not a invalid excel file, please try again.");
			return "shikaiupload";
		}
		 return "redirect:/dashboard";
	}
}
