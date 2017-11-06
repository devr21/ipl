package com.boot.ipl.util;

public enum RequestConstants {

	MATCH(10,0);
	
	private final int size;
	private final int page;
	
	RequestConstants(int size,int page){
		this.size = size;
		this.page=page;
	}

	public int getSize() {
		return size;
	}

	public int getPage() {
		return page;
	}
	
}
