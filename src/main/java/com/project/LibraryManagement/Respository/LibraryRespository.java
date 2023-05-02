package com.project.LibraryManagement.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Books;

@Repository
public interface LibraryRespository extends JpaRepository<Books,Integer>{
	
@Query(value = "select * from Books b where b.genre =:genre" , nativeQuery = true )
public List<Books> getBooksByGenre(String genre);

@Query(value = "update Books b set b.status =\"Rented\" where b.bookId =:bookId")
public String updateStatus(int bookId);
}
