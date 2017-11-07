package com.boot.ipl.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@GetMapping
	public Page<Match> getMatches(@RequestParam Map<String,String> params){

		Pageable p = getPageable(params);
		String season = params.get("season");
		List<String> seasons = Arrays.asList(season.split(",")); 
		if(isValid(season))
			return matchService.getBySeasons(seasons, p);
		
		return matchService.getAll(p);
	}
	
	@GetMapping("/{id}")
	public Match getById(@PathVariable("id") long id) {
		
		return matchService.getMatchById(id);
	}
	
}
