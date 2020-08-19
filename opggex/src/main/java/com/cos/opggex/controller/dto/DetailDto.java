package com.cos.opggex.controller.dto;

import java.util.List;

import com.cos.opggex.controller.dto.attr.MatchSummonerDto;
import com.cos.opggex.controller.dto.attr.MatchTeamDto;
import com.cos.opggex.model.MatchSummonerModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DetailDto {
	//entryModel
	private String tier;
	private int tierRank;
	
	//MachteamModel
	private List<MatchTeamDto> matchTeamDtos;
	
	//MatchSummonerModel
	List<MatchSummonerDto> matchSummonerDtos; 
	

	
}
