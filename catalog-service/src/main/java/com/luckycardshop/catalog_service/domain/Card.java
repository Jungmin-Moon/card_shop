package com.luckycardshop.catalog_service.domain;

public record Card(
	String name,
	String cardType,
	String attribute,
	int level,
	int rank,
	int pendScale,
	int linkArrows,
	String monsterType,
	String textBoxText,
	int atk,
	int def,
	int link,
	Double price
) {}
