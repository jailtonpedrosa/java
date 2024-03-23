package com.adm.dslist.dtos;

public record GameRecordDto(Long id, String title, Integer year, String genre, 
							String platforms, Double score, String imgUrl,
							String shortDescription, String longDescription) {
}
