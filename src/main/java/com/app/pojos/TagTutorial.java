package com.app.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="tag_tutorial",uniqueConstraints = @UniqueConstraint(columnNames = {"tag_id","tut_id"}))
public class TagTutorial extends BaseEntity {
	@Column(name="created_on")
	private LocalDate createdOn;
	//uni dir many to one relationship between Tag 1<-----*TagTutorial
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tag_id")
	private Tag tag;
	//uni dir many to one relationship between Tutorial 1<-----*TagTutorial
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tut_id")
	private Tutorial tutorial;
	
	public TagTutorial() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	@Override
	public String toString() {
		return "TagTutorial [createdOn=" + createdOn + "]";
	}
	
	
}
