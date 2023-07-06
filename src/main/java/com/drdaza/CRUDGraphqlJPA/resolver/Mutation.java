package com.drdaza.CRUDGraphqlJPA.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.repositories.AuthorRepository;
import com.drdaza.CRUDGraphqlJPA.repositories.BookRepository;

@Component
public class Mutation {
    @Autowired
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public Mutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author newAuthor = new Author(name, age);
        return authorRepository.save(newAuthor);
    }
}
