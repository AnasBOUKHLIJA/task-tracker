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

import com.taskTracker.dao.CommentDao;
import com.taskTracker.entities.Comment;

@RestController
@RequestMapping("/comment")
public class CommentController {
    
    @Autowired private CommentDao commentDao;
    
    @GetMapping("/getAll")
    public List<Comment> getAllComments() {
        return commentDao.findAll();
    }
    
    @GetMapping("/getById/{id}")
    public Comment getCommentById(@PathVariable Long id) {
    	Comment comment = commentDao.findById(id);
    	if(comment == null) throw new RuntimeException("Comment not found with id : " + id);
        return comment;
    }
    
    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment) {
    	comment.setCreatedAt(new Date());
        return commentDao.create(comment);
    }
    
    @PostMapping("/createList")
    public List<Comment> createComments(@RequestBody List<Comment> User) {
        return commentDao.createList(User);
    }
    
    @PutMapping("/update/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        Comment comment = commentDao.findById(id);
    	if(comment == null) throw new RuntimeException("Comment not found with id : " + id);
        // Update comment details
        comment.setContent(commentDetails.getContent());
        // Save updated comment
        commentDao.update(comment);
        return comment;
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        Comment comment = commentDao.findById(id);
    	if(comment == null) throw new RuntimeException("Comment not found with id : " + id);      
        commentDao.delete(comment);
    }
    
}

