package com.cos.opggex.model;

import lombok.Builder;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntryModel {
	
	private String leagueId;
	private String queueType;
	private String tier;
	private int rank;
	private String summonerId;
	private String summonerName;
	private int leaguePoints;
	private int wins;
	private int losses;
	
	
}
