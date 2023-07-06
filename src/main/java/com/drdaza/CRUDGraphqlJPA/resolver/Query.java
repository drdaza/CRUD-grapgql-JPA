package com.drdaza.CRUDGraphqlJPA.resolver;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.drdaza.CRUDGraphqlJPA.models.Author;
// import com.drdaza.CRUDGraphqlJPA.repositories.AuthorRepository;
// import com.drdaza.CRUDGraphqlJPA.repositories.BookRepository;

// @Component
public interface Query<T,U> {

    // @Autowired
    // private AuthorRepository authorRepository;
    // private BookRepository bookRepository;

    // public Query(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    // public List<Author> findAllAuthors() {
    //     return authorRepository.findAll();
    // }
    public List<T> findAll();
    public T findOne(U entity);
}
