package com.boot.ipl.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ipl.model.Match;
import com.boot.ipl.services.MatchService;
import com.boot.ipl.util.RequestConstants;

@RestController
@RequestMapping("/match")
public class MatchControllers extends BasicController{

	@Autowired
	private MatchService matchService;
	
	@GetMapping
	public Page<Match> getAll(@RequestParam Map<String,String> params){

		String value = params.get("page");
		int page = isValid(value)?Integer.parseInt(value):RequestConstants.MATCH.getPage();
		value = params.get("size");
		int size = isValid(value)?Integer.parseInt(value):RequestConstants.MATCH.getSize();
		String sort = params.get("sort");
		Pageable p = null;
		if(sort != null) {
			String dir = isValid(params.get("sort.dir"))?params.get("sort.dir"):"ASC";
			Sort s = new Sort(Direction.valueOf(dir.toUpperCase()),sort);
			p = new PageRequest(page,size,s);
		}
		else {
			p = new PageRequest(page,size);
		}
		
		return matchService.getAll(p);
	}
	
	@GetMapping("/{id}")
	public Match getById(@PathVariable("id") long id) {
		
		return matchService.getMatchById(id);
	}
	
}
