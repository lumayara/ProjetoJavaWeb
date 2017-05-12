/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.repository;

import com.mycompany.post.project.entity.Post;
import java.io.Serializable;

/**
 *
 * @author Luana
 */
public class PostRepository extends GenericRepository<Post> implements Serializable {

    public PostRepository() {
        super(Post.class);
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT p FROM Post p";
    }
    
}
