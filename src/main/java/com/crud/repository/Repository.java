package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Books;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Books, Integer> {

}
