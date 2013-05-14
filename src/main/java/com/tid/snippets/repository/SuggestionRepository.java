package com.tid.snippets.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tid.snippets.model.Suggestion;
import com.tid.snippets.model.User;



@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, String> {
	@Query("select s from Suggestion s where user.username =:name")
    List<Suggestion> readUserSuggestion(@Param("name") String name);
}

