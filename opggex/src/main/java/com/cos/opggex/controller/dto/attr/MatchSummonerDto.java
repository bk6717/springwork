package com.cos.opggex.controller.dto.attr;

import com.cos.opggex.controller.dto.DetailDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
