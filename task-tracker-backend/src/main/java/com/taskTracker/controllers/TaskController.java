package com.taskTracker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.dao.BugTaskDao;
import com.taskTracker.dao.FeatureTaskDao;
import com.taskTracker.dao.TaskDao;
import com.taskTracker.entities.BugTask;
import com.taskTracker.entities.FeatureTask;
import com.taskTracker.entities.Task;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired private TaskDao			taskDao;
    @Autowired private FeatureTaskDao 	featureTaskDao;
    @Autowired private BugTaskDao 		bugTaskDao;

    @GetMapping("/feature/getAll")
    public List<FeatureTask> getAllFeatureTasks() {
        return featureTaskDao.findAll();
    }
    
    @GetMapping("/feature/getById/{id}")
    public FeatureTask getFeatureTaskById(@PathVariable Long id) {
    	FeatureTask featureTask = featureTaskDao.findById(id);
    	if(featureTask == null) throw new RuntimeException("Feature Task not found with id : " + id);      
        return featureTask;
    }
    
    @PostMapping("/feature/create")
    public Task createFeatureTask(@RequestBody FeatureTask featureTask) {
    	featureTask.setCreatedAt(new Date());
        return featureTaskDao.create(featureTask);
    }
    
    @PostMapping("/feature/createList")
    public List<FeatureTask> createFeatureTasks(@RequestBody List<FeatureTask> featureTasks) {
        return featureTaskDao.createList(featureTasks);
    }
    
    @GetMapping("/bug/getAll")
    public List<BugTask> getAllBugTasks() {
        return bugTaskDao.findAll();
    }
    
    @GetMapping("/bug/getById/{id}")
    public Task getBugTaskById(@PathVariable Long id) {
    	Task task = bugTaskDao.findById(id);
    	if(task == null) throw new RuntimeException("Project not found with id : " + id);      
        return task;
    }
    
    @PostMapping("/bug/create")
    public Task createBugTask(@RequestBody BugTask bugTask) {
    	bugTask.setCreatedAt(new Date());
        return bugTaskDao.create(bugTask);
    }
    
    @PostMapping("/bug/createList")
    public List<BugTask> createBugTasks(@RequestBody List<BugTask> bugTasks) {
        return bugTaskDao.createList(bugTasks);
    }
        
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        Task task = taskDao.findById(id);
    	if(task == null) throw new RuntimeException("Project not found with id : " + id);      

        taskDao.delete(task);
    }
}
