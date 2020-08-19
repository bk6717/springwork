package com.cos.opggex.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingDto {
	
	// SummonoerModel
	private String name;
	private int summonoerLevel;
	private int profileIconId;
	
	//RankingModel
	private String tier;
	private int tierRank;
	private int lp;
	private String win;
	private String lose;
	
}
