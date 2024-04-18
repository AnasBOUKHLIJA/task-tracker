package com.taskTracker.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.Project;
import com.taskTracker.generic.GenericDao;

@Component
public class ProjectDao extends GenericDao<Project> {

	@Override
	public void setEntityClass() {
		this.entityClass = Project.class;
	}
	
	public List<Project> createList(List<Project> projects){
		List<Project> projectsList = new ArrayList<Project>();
		for (Project project : projects) {
	    	project.setCreatedAt(new Date());
			projectsList.add(create(project));
		}
		return projectsList;
	}

}
