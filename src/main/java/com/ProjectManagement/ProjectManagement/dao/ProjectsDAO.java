package com.ProjectManagement.ProjectManagement.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Repository;

import com.ProjectManagement.ProjectManagement.Model.Project;
import com.ProjectManagement.ProjectManagement.Model.Projects;
import com.ProjectManagement.ProjectManagement.exceptions.EntryAlreadyExists;

@Repository
public class ProjectsDAO {

	static Projects  plist=new Projects();
	static {
		LocalDateTime  ldt=LocalDateTime.now();
		Project  p1=new Project(); p1.setProjectId(100);p1.setProjectName("HSBC"); 
		p1.setStartDate(ldt.toString());
		p1.setEndDate(ldt.plusDays(300).toString());
		
		Project  p2=new Project(); p2.setProjectId(101); p2.setProjectName("Shell Corporation");
		p2.setStartDate(ldt.toString());
		p2.setEndDate(ldt.plusDays(300).toString());
		
		plist.getProjectsList().add(p1);
		plist.getProjectsList().add(p2);
		System.err.println("Projects List initialized....");
	}
	public Projects getAllProjects() {
		return plist;
	}
	public void addProject(Project p) {
		boolean found=false;
		System.err.println("************");
		for(Project  p1:plist.getProjectsList())
				if(p.getProjectId() == p1.getProjectId())
					found=true;
		if (found)
			throw  new EntryAlreadyExists
			("Project with id " + p.getProjectId() + " already exists..");
		else
			plist.getProjectsList().add(p);
}
	public void deleteProject(String projectname) {
		List <Project>l=plist.getProjectsList();
		for(Project p: l)
		{
			if(p.getProjectName().equalsIgnoreCase(projectname))
			{
				l.remove(p);
				System.out.println("Project stopped...");
			}
		}
	}
	
}