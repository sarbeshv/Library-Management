package com.project.LibraryManagement.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Users;

@Repository
public interface UsersRespository extends JpaRepository<Users,Integer> {

}