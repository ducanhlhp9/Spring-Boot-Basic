package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "news")

public class NewsEntity extends BaseEntity {
	@Column(name = "title")
	private String title;

	@Column(name = "thumbnai")
	private String thumbnai;

	@Column(name = "shortdescription")
	private String shortDescription;

	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name ="category_id")
	private CategoryEntity category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnai() {
		return thumbnai;
	}

	public void setThumbnai(String thumbnai) {
		this.thumbnai = thumbnai;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	

}
