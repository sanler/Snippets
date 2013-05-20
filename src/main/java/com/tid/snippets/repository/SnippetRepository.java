package com.tid.snippets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tid.snippets.model.Snippet;
import com.tid.snippets.model.Suggestion;


@Repository
public interface SnippetRepository extends JpaRepository<Snippet, String> {
	
}
