package com.taskTracker.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.Comment;
import com.taskTracker.generic.GenericDao;

@Component
public class CommentDao extends GenericDao<Comment> {

	@Override
	public void setEntityClass() {
		this.entityClass = Comment.class;
	}

	public List<Comment> createList(List<Comment> comments){
		List<Comment> commentsList = new ArrayList<Comment>();
		for (Comment comment : comments) {
	    	comment.setCreatedAt(new Date());
			commentsList.add(create(comment));
		}
		return commentsList;
	}
	
}
