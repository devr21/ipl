package com.boot.ipl.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.ipl.model.Match;

public interface MatchService {

	Page<Match> getAll(Pageable pageable);
	void save(Match match);
	Match getMatchById(final long id);
	
}
