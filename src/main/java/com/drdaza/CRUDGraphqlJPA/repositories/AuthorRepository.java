package com.drdaza.CRUDGraphqlJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drdaza.CRUDGraphqlJPA.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{
    
}
