package com.stackroute.mediclaim.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.mediclaim.model.Applicant;
import com.stackroute.mediclaim.repository.AppRepo;

@Controller
public class MediclaimController {

	ApplicationContext appcontext=new ClassPathXmlApplicationContext("beans.xml");
	AppRepo apprepo=appcontext.getBean("apprepo",AppRepo.class);
	
	
	@GetMapping("/")
	public String processFirst()
	{
		return "index";
	}
	
	@PostMapping("/saveuser")
	public String saveApplicant(@ModelAttribute("applicant") Applicant applicant,ModelMap modelmap)
	{
		apprepo.addApplicant(applicant);
		
		modelmap.put("applidetails", apprepo.getAllApplicants());
		return "index";
		
	}
	
	@GetMapping("/delrecord")
	public String deleteApplicant(@RequestParam("aname") String nm,ModelMap modelmap)
	{
		
		apprepo.deleteApplicant(nm);
		modelmap.put("applidetails", apprepo.getAllApplicants());
		return "index";
		
	}
	@GetMapping("/modirecord")
	public String fetchApplicant(@RequestParam("aname") String nm,ModelMap modelmap)
	{
		Applicant appresult=apprepo.findByname(nm);
		modelmap.put("applidetails", apprepo.getAllApplicants());
		modelmap.put("appresult", appresult);
		return "index";
	}

	@RequestMapping("/update")
	public String updateRecord(@ModelAttribute("applicant") Applicant appliobj,ModelMap modelmap)
	{
		apprepo.updateApplication(appliobj);
		
		return "index";
	}
	
	
}
