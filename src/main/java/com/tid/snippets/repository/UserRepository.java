package com.tid.snippets.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tid.snippets.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

