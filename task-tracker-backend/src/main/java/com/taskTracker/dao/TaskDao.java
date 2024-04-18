package com.taskTracker.dao;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.Task;
import com.taskTracker.generic.GenericDao;


@Component
public class TaskDao extends GenericDao<Task> {

	@Override
	public void setEntityClass() {
		this.entityClass = Task.class;
	}

}
