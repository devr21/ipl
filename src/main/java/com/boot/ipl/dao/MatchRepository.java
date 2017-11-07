package com.boot.ipl.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.ipl.model.Match;

public interface MatchRepository extends JpaRepository<Match, Serializable>{

	Page<Match> findBySeasonIn(List<String> season,Pageable pageable);
	
}
