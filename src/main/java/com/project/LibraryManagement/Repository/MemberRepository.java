package com.project.LibraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

