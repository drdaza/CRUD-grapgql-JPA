package com.drdaza.CRUDGraphqlJPA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations.AuthorMutation;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.AuthorQuery;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorMutation authorMutation;
    private AuthorQuery authorQuery;
    public AuthorService(AuthorQuery authorQuery) {
        this.authorQuery = authorQuery;
    }

    public List<Author> findAllAuthors(){
        return authorQuery.findAll();
    }

    public Author findOneAuthor(Long authorId){
        return authorQuery.findOne(authorId);
    }

    public Author createAuthor(String name, Integer age){
        Author newAuthor = new Author(name, age);

        return authorMutation.create(newAuthor);
    }

    public Author updateAuthor(Long id, String name, Integer age){
        Author updateAuthor = new Author();
        updateAuthor.setId(id);
        updateAuthor.setAge(age);
        updateAuthor.setName(name);
        return authorMutation.update(updateAuthor);
    }

    public List<Author> deleteAuthor(Long id){
        Author authorToDelete = new Author();
        authorToDelete.setId(id);
        authorToDelete.setAge(0);
        authorToDelete.setName("default");
        return authorMutation.delete(authorToDelete);
    }
}
