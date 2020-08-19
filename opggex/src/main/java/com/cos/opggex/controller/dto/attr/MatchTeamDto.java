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
public class MatchTeamDto {
	
	//MachteamModel
	private String win;
	private int towerKills;
	private int baronKills;
	private int dragonkils;
}
