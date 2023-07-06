package com.drdaza.CRUDGraphqlJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.resolver.Mutation;
import com.drdaza.CRUDGraphqlJPA.resolver.Query;


@Controller
public class AuthorController {
    @Autowired
    private Query query;
    private Mutation mutation;

    public AuthorController(Mutation mutation) {
        this.mutation = mutation;
    }

    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument Integer age){
        return mutation.createAuthor(name, age);
    }

    @QueryMapping
    public List<Author> findAllAuthors(){
        return query.findAllAuthors();
    } 
}
