package com.alam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
	public int number;
	public String title;
	public String originalTitle;
	public String releaseDate;
	public String description;
	public int pages;
	public String cover;
	public int index;
}
