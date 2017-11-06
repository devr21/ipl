package com.boot.ipl.controllers;

public class BasicController {

	protected boolean isValid(String value) {
		return value != null && value != ""?true:false;
	}
	
}
