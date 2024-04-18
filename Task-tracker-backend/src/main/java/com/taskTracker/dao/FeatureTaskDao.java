package com.taskTracker.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taskTracker.entities.FeatureTask;
import com.taskTracker.generic.GenericDao;


@Component
public class FeatureTaskDao extends GenericDao<FeatureTask> {

	@Override
	public void setEntityClass() {
		this.entityClass = FeatureTask.class;
	}

	public List<FeatureTask> createList(List<FeatureTask> featureTasks) {
		List<FeatureTask> featureTasksList = new ArrayList<FeatureTask>();
		for (FeatureTask featureTask : featureTasks) {
	    	featureTask.setCreatedAt(new Date());
			featureTasksList.add(create(featureTask));
		}
		return featureTasksList;
	}

}
