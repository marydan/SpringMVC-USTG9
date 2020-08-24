package com.stackroute.mediclaim.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.stackroute.mediclaim.model.Applicant;

public class AppRepo {

	ArrayList<Applicant> applicants;
	
	AppRepo()
	{
		applicants=new ArrayList();
	}
	
	public boolean addApplicant(Applicant appobject)
	{
		applicants.add(appobject);
		return true;
	}
	
	public ArrayList getAllApplicants()
	{
		return applicants;
	}
	
	public Applicant findByname(String name)
	{
		List<Applicant> appli=applicants.stream().filter( s->s.getUname().equals(name)).collect(Collectors.toList());
		return appli.get(0);
 	}
	
	
	public boolean deleteApplicant(String name)
	{
		
		Predicate<Applicant> pred= (appobj)-> (appobj.getUname().equals(name));
		
		applicants.removeIf(pred);
		return true;
	}
	
	
	public boolean updateApplication(Applicant applicant)
	{
		
		return true;
	}
	
}
