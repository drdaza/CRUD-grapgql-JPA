package com.drdaza.CRUDGraphqlJPA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations.BookMutation;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.AuthorQuery;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.BookQuery;

@Service
public class BookService {

    @Autowired
    private BookMutation bookMutation;
    private BookQuery bookQuery;
    private AuthorQuery authorQuery;

    public BookService(BookQuery bookQuery, AuthorQuery authorQuery) {
        this.bookQuery = bookQuery;
        this.authorQuery = authorQuery;
    }

    public List<Book> findAllBooks() {
        return bookQuery.findAll();
    }

    public Book findOneBook(Long bookId) {
        return bookQuery.findOne(bookId);
    }

    public Book createBook(String title, String description, Long authorid) {

        Author authorDB = authorQuery.findOne(authorid);
        List<Author> authors = new ArrayList<>();
        Book newBook = new Book(title, description, authors);

        if (authorDB.getClass() != null) {
            authors.add(authorDB);
            newBook.setAuthors(authors);
            return bookMutation.create(newBook);
        }

        if (authors.isEmpty()) {
            return null;
        }

        return bookMutation.create(newBook);
    }

    public Book updateBook(Long bookId, String title, String description) {
        Book bookDB = bookQuery.findOne(bookId);

        if (bookDB.getClass().isInstance(Book.class)) {
            return null;
        }

        bookDB.setDescription(description);
        bookDB.setTitle(title);

        return bookMutation.update(bookDB);
    }

    public List<Book> deleteBook(Long id){
        Book bookDB = bookQuery.findOne(id);

        if (bookDB.getClass().isInstance(Book.class)) {
            return null;
        }

        return bookMutation.delete(bookDB);
    }
}
