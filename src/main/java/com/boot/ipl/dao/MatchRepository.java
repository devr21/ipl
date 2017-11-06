package com.boot.ipl.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.ipl.model.Match;

public interface MatchRepository extends JpaRepository<Match, Serializable>{

	
	
}
