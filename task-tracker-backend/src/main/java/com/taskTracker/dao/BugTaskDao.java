package com.taskTracker.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.BugTask;
import com.taskTracker.generic.GenericDao;


@Component
public class BugTaskDao extends GenericDao<BugTask> {

	@Override
	public void setEntityClass() {
		this.entityClass = BugTask.class;
	}

	public List<BugTask> createList(List<BugTask> bugTasks) {
		List<BugTask> bugTasksList = new ArrayList<BugTask>();
		for (BugTask bugTask : bugTasks) {
	    	bugTask.setCreatedAt(new Date());
			bugTasksList.add(create(bugTask));
		}
		return bugTasksList;
	}

}
