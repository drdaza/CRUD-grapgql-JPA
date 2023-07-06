package com.drdaza.CRUDGraphqlJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drdaza.CRUDGraphqlJPA.models.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}
