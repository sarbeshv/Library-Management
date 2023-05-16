package com.project.LibraryManagement.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Librarian;

@Repository
public interface LibrarianRespository extends JpaRepository<Librarian,Integer>{
	

}

