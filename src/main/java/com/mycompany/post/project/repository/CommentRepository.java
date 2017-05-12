/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.repository;

import com.mycompany.post.project.entity.Comment;
import java.io.Serializable;

/**
 *
 * @author Luana
 */
public class CommentRepository extends GenericRepository<Comment> implements Serializable {

    public CommentRepository() {
        super(Comment.class);
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT c FROM Comment c";
    }
    
}
