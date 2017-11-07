package com.boot.ipl.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.boot.ipl.util.RequestConstants;

public class BasicController {

	private Logger logger = LoggerFactory.getLogger(BasicController.class);
	
	protected boolean isValid(String value) {
		return value != null && value != ""?true:false;
	}
	
	protected Pageable getPageable(Map<String,String> params){
		
		String value = params.get("page");
		int page = isValid(value)?Integer.parseInt(value):RequestConstants.MATCH.getPage();
		value = params.get("size");
		int size = isValid(value)?Integer.parseInt(value):RequestConstants.MATCH.getSize();
		String sort = params.get("sort");
		Pageable p = null;
		if(sort != null) {
			String dir = null;
			dir = isValid(params.get("sort.dir"))?params.get("sort.dir"):"asc";
			
			Sort s = null;
			try{
				s = new Sort(Direction.valueOf(dir.toUpperCase()),sort);
			}catch(IllegalArgumentException e){
				s = new Sort(Direction.ASC,sort);
			}
			p = new PageRequest(page,size,s);
		}
		else {
			p = new PageRequest(page,size);
		}
		
		return p;
	}
	
}
