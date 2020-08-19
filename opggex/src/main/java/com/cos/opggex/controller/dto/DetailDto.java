package com.cos.opggex.controller.dto;

import java.util.List;

import com.cos.opggex.model.MatchSummonerModel;

public class DetailDto {
	//entryModel
	private String tier;
	private int tierRank;
	
	//MachteamModel
	private List<MatchTeamDto> matchTeamDtos;
	
	//MatchSummonerModel
	List<MatchSummonerDto> matchSummonerDtos; 
	
	public class MatchTeamDto {
		
		//MachteamModel
		private String win;
		private int towerKills;
		private int baronKills;
		private int dragonkils;
	}
	
	public class MatchSummonerDto{
		private String summonerName;
		private int participantId;
		private int championId;
		private int spell1Id;
		private int spell2Id;
		private boolean win;
		private int item0;
		private int item1;
		private int item2;
		private int item3;
		private int item4;
		private int item5;
		private int item6;
		private int kills;
		private int deaths;
		private int assists;
		private int totalDamageDealtToChampions;
		private int totalMinionsKilled;
		private int champLevel;
		private int sightWardsBoughtInGame;
		private int wardsPlaced;
		private int wardsKilled;
		private int perkPrimaryStyle;
		private int perkSubStyle;
	}

	
}
