package com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.repositories.AuthorRepository;
import com.drdaza.CRUDGraphqlJPA.resolver.Query;

@Component
public class AuthorQuery implements Query<Author, Long>{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findOne(Long entity) {
        return authorRepository.findById(entity).orElseThrow(() -> new RuntimeException("Author not found"));
    }
    
}
