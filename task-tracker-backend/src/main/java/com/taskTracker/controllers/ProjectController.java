package com.taskTracker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskTracker.dao.ProjectDao;
import com.taskTracker.entities.Project;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired private ProjectDao projectDao;
    
    @GetMapping("/getAll")
    public List<Project> getAllProjects() {
    	List<Project> projects = projectDao.findAll();
        return projects;
    }
    
    @GetMapping("/getById/{id}")
    public Project getProjectById(@PathVariable Long id) {
    	Project project = projectDao.findById(id);
    	if(project == null) throw new RuntimeException("Project not found with id : " + id);      
        return project;
    }
    
    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
    	project.setCreatedAt(new Date());
        return projectDao.create(project);
    }
    
    @PostMapping("/createList")
    public List<Project> createProjects(@RequestBody List<Project> User) {
        return projectDao.createList(User);
    }
    
    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        Project project = projectDao.findById(id);
    	if(project == null) throw new RuntimeException("Project not found with id : " + id);      

        // Update project details
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        // Save updated project
        projectDao.update(project);
        return project;
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        Project project = projectDao.findById(id);
    	if(project == null) throw new RuntimeException("Project not found with id : " + id);      

        projectDao.delete(project);
    }
}
