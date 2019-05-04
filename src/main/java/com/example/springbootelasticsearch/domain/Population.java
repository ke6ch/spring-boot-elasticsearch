package com.example.springbootelasticsearch.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Population {
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date year;
	
	@JsonProperty("pefectures_code")
	private int pefecturesCode;

	@JsonProperty("pefectures_name")
	private String pefecturesName;

	@JsonProperty("total_population")
	private int totalPopulation;

	@JsonProperty("younger_population")
	private int youngerPopulation;

	@JsonProperty("production_population")
	private int productionPopulation;

	@JsonProperty("elderly_population")
	private int elderlyPopulation;
		
}