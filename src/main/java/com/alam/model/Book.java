package com.alam.model;

import com.alam.dto.BookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String title;
	public String originalTitle;
	public String releaseDate;
	@Column(length = 1000)
	public String description;
	public int pages;
	public String cover;
	public int index;

	public Book(BookDTO book) {
		this.title = book.title;
		this.originalTitle = book.originalTitle;
		this.releaseDate = book.releaseDate;
		this.description = book.description;
		this.pages = book.pages;
		this.cover = book.cover;
		this.index = book.index;
	}

	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
