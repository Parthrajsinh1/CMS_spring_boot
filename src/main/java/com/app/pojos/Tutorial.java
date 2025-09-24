package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial extends BaseEntity {

	@Column(length = 100, unique = true)
	private String title;
	// private String author : replaces by the author entity ref.
	@Column(name = "pub_date")
	private LocalDate publidhDate;
	private int visits;
	@Column(length = 400)
	private String contents;

	// Many to One relationship between 2 entities
	@ManyToOne(fetch = FetchType.LAZY) // MANDATORY -- o.w will get org.hib.MappingExc
	@JoinColumn(name = "selected_topic_id", nullable = false) // optional to specify FK column name n constraints / if
																// we do not add join column hibernate will decide name
																// of column
	private Topic topic;
	// Many to one , uni dir asso between tutorial *--->1 user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private User author;
	// bi dir relationship between tutorial ---> comment
	@OneToMany(mappedBy = "tutorial",cascade = CascadeType.ALL) //Mandatory : o.w mapping exc
	private List<Comment> comments = new ArrayList<>();

	public Tutorial() {
		// TODO Auto-generated constructor stub
	}

	public Tutorial(String title, LocalDate publidhDate, String contents) {
		super();
		this.title = title;
		this.publidhDate = publidhDate;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public LocalDate getPublidhDate() {
		return publidhDate;
	}

	public void setPublidhDate(LocalDate publidhDate) {
		this.publidhDate = publidhDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	// project tip : DO NOT ADD relationship fields in the toString

	@Override
	public String toString() {
		return "Tutorial" + getId() + "[title=" + title + ",  publidhDate=" + publidhDate + ", visits=" + visits
				+ ", contents=" + contents + "]";
	}

}
