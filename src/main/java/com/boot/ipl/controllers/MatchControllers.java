package com.boot.ipl.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ipl.model.Match;
import com.boot.ipl.services.MatchService;

@RestController
@RequestMapping("/match")
public class MatchControllers extends BasicController{

	@Autowired
	private MatchService matchService;
	
	private static Logger logger = LoggerFactory.getLogger(MatchControllers.class);
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_RS_READ')")
	public Page<Match> getMatches(@RequestParam Map<String,String> params){

		Pageable p = getPageable(params);
		String season = params.get("season");
		logger.info("season values: "+season); 
		if(isValid(season)) {
			List<String> seasons = Arrays.asList(season.split(","));
			logger.info("seasons array: "+seasons.isEmpty());
			return matchService.getBySeasons(seasons, p);
		}
		return matchService.getAll(p);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_RS_READ')")
	public Match getById(@PathVariable("id") long id) {
		
		return matchService.getMatchById(id);
	}
	
}
