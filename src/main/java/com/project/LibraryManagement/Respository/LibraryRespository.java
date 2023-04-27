package com.project.LibraryManagement.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Books;

@Repository
public interface LibraryRespository extends JpaRepository<Books,Integer>{
	



}
