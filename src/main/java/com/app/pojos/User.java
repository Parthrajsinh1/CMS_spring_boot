package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 30) // varchar(30)
	private String lastName;
	@Column(length = 20, unique = true) // add unique constraint
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL constraint
	private String password;
	// uni dir many to many relationship netween entities : User *-->*Role
	@ManyToMany //MANDATORY , o.w hib throw Mapping exc
	//annotation below : optional but reco for customizing names of the link table n its cols
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id") )
	@JsonIgnore
	private Set<Role> roles = new HashSet<>(); // as per Gavin King's suggestion , init collection to empty
	//uni dir asso between Entity n value type : User 1---->1 Passport
	@Embedded //OPTIONAL but rec for understanding !
	@JsonIgnore
	private Passport passport;
	//uni dir one to many asso between Entity Basic value type
	@ElementCollection //to indicate collection of value type
	@CollectionTable(name="user_hobbies",joinColumns = @JoinColumn(name="user_id"))
	@Column(name="hobby",length=20)
	@JsonIgnore
	private List<String> hobbies = new ArrayList<>(); 
	//uni dir one to many asso between Entity Basic n Composite value type
	@ElementCollection //to indicate collection of value type
	@CollectionTable(name="user_cards",joinColumns = @JoinColumn(name="u_id"))
	@JsonIgnore
	private List<Card> cards = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	//as per Gavin kings rec : add helper (convenience methods to add role n remove role
	//optional but reco!
	
	public void addRole(Role role) {
	    this.roles.add(role);
	}

	
	public void removeRole(Role role) {
		roles.remove(role);
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "User ID " + getId() + " firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
	}

}