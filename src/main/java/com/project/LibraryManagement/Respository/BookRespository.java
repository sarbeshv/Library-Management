package com.project.LibraryManagement.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Books;

import jakarta.transaction.Transactional;

@Repository
public interface BookRespository extends JpaRepository<Books, Integer> {

	@Query(value = "select * from Books b where b.genre =:genre", nativeQuery = true)
	public List<Books> getBooksByGenre(String genre);

	@Transactional
	@Modifying
	@Query(value = "update Books b set b.status =\"Rented\" ,b.no_of_days=?2 ,b.issued_user=?3 where b.book_Id =?1", nativeQuery = true)
	public void updateStatus(int bookId, int no_of_days, int issued_user);
	
	
	@Transactional
	@Modifying
	@Query(value = "update Books b set b.status =\"Available\" ,b.no_of_days=0 ,b.issued_user=0 where b.book_Id =?1", nativeQuery = true)
	public void availUpdateStatus(int bookId);
}
