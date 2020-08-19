package com.cos.opggex.controller.dto;

import java.util.List;

import com.cos.opggex.controller.dto.DetailDto.DetailDtoBuilder;
import com.cos.opggex.controller.dto.DetailDto.MatchSummonerDto;
import com.cos.opggex.controller.dto.DetailDto.MatchTeamDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoDto {
	
	private int type;
	// SummonoerModel
	private String name;
	private int summonoerLevel;
	private int profileIconId;
	
	//entrymodel
	private String queueType;
	private String tier;
	private int rank;
	private int leaguePoints;
	private int wins;
	private int losses;
	
	private List<MatchDto> matchDtos;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class MatchDto {
		
		//MatchCommonModel
		private long gameCreation;
		private int gameDuration;
		
		//MatchTeamModel
		private String win;
		
		//MatchSummonerModel
		private String summonerName;
		private long gameId;
		private int participantId;
		private int championId;
		private int spell1Id;
		private int spell2Id;
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
		private int champLevel;
		private int sightWardsBoughtInGame;
		private int wardsPlaced;
		private int wardsKilled;
		private int perkPrimaryStyle;
		private int perkSubStyle;
		
		//entryModel
		private String tier;
		private int tierRank;
	}
}
