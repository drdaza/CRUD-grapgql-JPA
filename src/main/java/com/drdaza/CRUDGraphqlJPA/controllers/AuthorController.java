package com.drdaza.CRUDGraphqlJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.services.AuthorService;


@Controller
public class AuthorController {
    @Autowired
    private AuthorService service;


    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument Integer age){
        return service.createAuthor(name, age);
    }

    @MutationMapping
    public Author updateAuthor(@Argument Long id, @Argument String name, @Argument Integer age){
        return service.updateAuthor(id, name, age);
    }

    @MutationMapping
    public List<Author> deleteAuthor(@Argument Long id){
        return service.deleteAuthor(id);
    }

    @QueryMapping
    public List<Author> findAllAuthors(){
        return service.findAllAuthors();
    } 
}
