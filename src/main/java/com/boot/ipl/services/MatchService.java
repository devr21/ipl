package com.boot.ipl.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.ipl.model.Match;

public interface MatchService {

	Page<Match> getAll(Pageable pageable);
	void save(Match match);
	Match getMatchById(final long id);
	Page<Match> getBySeasons(List<String> season,Pageable pageable);
	
}
