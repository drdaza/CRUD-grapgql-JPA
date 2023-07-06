package com.drdaza.CRUDGraphqlJPA.resolver;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.drdaza.CRUDGraphqlJPA.models.Author;
// import com.drdaza.CRUDGraphqlJPA.repositories.AuthorRepository;
// import com.drdaza.CRUDGraphqlJPA.repositories.BookRepository;


public interface Mutation<T,U> {
    // @Autowired
    // private AuthorRepository authorRepository;
    // private BookRepository bookRepository;

    // public Mutation(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    // public Author createAuthor(String name, Integer age) {
    //     Author newAuthor = new Author(name, age);
    //     return authorRepository.save(newAuthor);
    // }
    public T create(T entity);
    public T update(T entity);
    public List<T> delete(T entity);
}
