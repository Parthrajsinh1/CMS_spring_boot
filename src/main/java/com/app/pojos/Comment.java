package com.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/*
Association between tutorial n comment
comment : many , child , owning(since has to contain FK)
*/
@Entity
@Table(name="comments",uniqueConstraints = @UniqueConstraint(columnNames = {"tut_id","cust_id"}))
public class Comment extends BaseEntity {
	@Column(name="comment_text")
	private String commentText;
	//bi dir relationship between Tutorial 1<----*comment
	@ManyToOne
	@JoinColumn(name="tut_id",nullable = false)
	private Tutorial tutorial;
	//uni dir relationship between user<----*comment
	@ManyToOne
	@JoinColumn(name="cust_id",nullable = false)
	private User customer;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	// NEVER EVER add relationships fields in toString - cause to recursion or stack
	// overflow
	@Override
	public String toString() {
		return "Comment ID" + getId() + " [commentText=" + commentText + "]";
	}

}
