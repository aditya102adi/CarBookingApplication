package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rider")
public class Rider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double rating;
	
	
	// Rider is a user
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Rider() {
		
	}

	public Rider(Long id, Double rating, User user) {
		super();
		this.id = id;
		this.rating = rating;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
