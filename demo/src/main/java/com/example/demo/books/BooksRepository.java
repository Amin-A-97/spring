package com.example.demo.books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity,Long> {



    Optional<BooksEntity> findByTitle(String title);

}
