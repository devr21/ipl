package com.boot.ipl.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.ipl.model.Match;

@Component
public class DataInitializer {

	@Autowired
	private MatchServiceImpl service;
	
	@PostConstruct
	public void init() {
		try {
			load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void load() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/resources/matches.csv"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String line = br.readLine();
		while(br.ready()) {
			Match match = new Match();
			
			String l = br.readLine();
			String[] arr = l.split(",");
			match.setSeason(arr[1]);
			match.setCity(arr[2]);
			match.setDate(Date.valueOf(arr[3]));
			match.setTeam1(arr[4]);
			match.setTeam2(arr[5]);
			match.setTossWinner(arr[6]);
			match.setTossDecision(arr[7]);
			match.setResult(arr[8]);
			match.setDlApplied(arr[9].equals(0+"")?false:true);
			match.setWinner(arr[10]);
			match.setWinByRuns(Integer.parseInt(arr[11]));
			match.setWinByWickets(Integer.parseInt(arr[12]));
			match.setPlayerOfMatch(arr[13]);
			String venue = arr[14];
			if(venue.startsWith("\""))
				venue = venue.substring(1);
			match.setVenue(venue);
			match.setUmpire1(arr[15]);
			match.setUmpire2(arr[16]);
			try {
			match.setUmpire3(arr[17]);
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			
			service.save(match);
		}
		
		
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
