package com.cos.opggex.controller.dto;

import java.util.List;

import com.cos.opggex.controller.dto.attr.MatchDto;

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
	

}
