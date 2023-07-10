package com.drdaza.CRUDGraphqlJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.services.BookService;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String description, @Argument Long authorId ){
        return bookService.createBook(title, description, authorId);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument String title,@Argument String description){
        return bookService.updateBook(id, title, description);
    }

    @MutationMapping
    public List<Book> deleteBook(@Argument Long id){
        return bookService.deleteBook(id);
    }

    @QueryMapping
    public Book findOneBook(@Argument Long bookId){
        return bookService.findOneBook(bookId);
    }
    
    @QueryMapping
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    
}
