package com.boot.ipl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="matches")
public class Match implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String team1;
	
	@NotNull
	private String team2;
	
	private String season;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String city;
	
	private String tossWinner;
	
	private String tossDecision;
	
	private String result;
	
	private String winner;
	
	private boolean dlApplied;
	
	private int winByRuns;
	
	private int winByWickets;
	
	private String playerOfMatch;
	
	private String venue;
	
	private String umpire1;
	
	private String umpire2;
	
	private String umpire3;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public boolean isDlApplied() {
		return dlApplied;
	}

	public void setDlApplied(boolean dlApplied) {
		this.dlApplied = dlApplied;
	}

	public int getWinByRuns() {
		return winByRuns;
	}

	public void setWinByRuns(int winByRuns) {
		this.winByRuns = winByRuns;
	}

	public int getWinByWickets() {
		return winByWickets;
	}

	public void setWinByWickets(int winByWickets) {
		this.winByWickets = winByWickets;
	}

	public String getPlayerOfMatch() {
		return playerOfMatch;
	}

	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getUmpire1() {
		return umpire1;
	}

	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}

	public String getUmpire2() {
		return umpire2;
	}

	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}

	public String getUmpire3() {
		return umpire3;
	}

	public void setUmpire3(String umpire3) {
		this.umpire3 = umpire3;
	}
	
}
