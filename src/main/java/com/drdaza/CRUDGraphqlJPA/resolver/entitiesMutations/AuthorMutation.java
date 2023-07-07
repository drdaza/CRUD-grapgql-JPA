package com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drdaza.CRUDGraphqlJPA.exceptions.AuthorNotFoundException;
import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.repositories.AuthorRepository;
import com.drdaza.CRUDGraphqlJPA.resolver.Mutation;

@Component
public class AuthorMutation implements Mutation<Author, Long>{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author create(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author update(Author entity) {
        Author authorDB = authorRepository.findById(entity.getId()).orElseThrow(() -> new AuthorNotFoundException("author not found"));
        authorDB.setName(entity.getName());
        authorDB.setAge(entity.getAge());
        return authorRepository.save(authorDB);
    }

    @Override
    public List<Author> delete(Author entity) {
        authorRepository.delete(entity);
        return authorRepository.findAll();
    }
    
}
