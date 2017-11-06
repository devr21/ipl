package com.boot.ipl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.boot.ipl.dao.MatchRepository;
import com.boot.ipl.model.Match;

@Component
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchRepository repo;
	
	@Transactional
	public void save(Match match) {
		repo.saveAndFlush(match);
	}
	
	public Match getMatchById(final long id) {
		return repo.findOne(id);
	}
	
	public Page<Match> getAll(Pageable pageable){
		return repo.findAll(pageable);
	}
	
}
