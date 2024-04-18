package com.taskTracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.User;
import com.taskTracker.generic.GenericDao;

@Component
public class UserDao extends GenericDao<User> {

	@Override
	public void setEntityClass() {
		this.entityClass = User.class;
	}
	
	public List<User> createList(List<User> users){
		List<User> usersList = new ArrayList<User>();
		for (User user : users) {
			usersList.add(create(user));
		}
		return usersList;
	}

}
