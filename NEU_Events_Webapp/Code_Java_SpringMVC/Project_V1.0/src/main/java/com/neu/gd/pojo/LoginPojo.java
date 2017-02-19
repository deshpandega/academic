/**
 * 
 */
package com.neu.gd.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author GD
 *
 */

@Entity
@Table(name="login_table")
public class LoginPojo {
	@Id
	private String neuID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="attempts")
	private int attempts;
	
	@Column(name="confirmationLink")
	private String confirmationLink;
	
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private PersonPojo person;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
	private Set<EventPojo> eventSet;
	
	@ManyToMany(mappedBy = "subscribers")
	private Set<EventPojo> subscribedEvents;
	
	public LoginPojo() {
		this.eventSet = new HashSet<EventPojo>();
		this.subscribedEvents = new HashSet<EventPojo>();
	}
	
	public String getNeuID() {
		return neuID;
	}
	public void setNeuID(String neuID) {
		this.neuID = neuID;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	public String getConfirmationLink() {
		return confirmationLink;
	}
	public void setConfirmationLink(String confirmationLink) {
		this.confirmationLink = confirmationLink;
	}
	
	public PersonPojo getPerson() {
		return person;
	}
	public void setPerson(PersonPojo person) {
		this.person = person;
	}

	public Set<EventPojo> getEventSet() {
		return eventSet;
	}
	public void setEventSet(Set<EventPojo> eventSet) {
		this.eventSet = eventSet;
	}

	public Set<EventPojo> getSubscribedEvents() {
		return subscribedEvents;
	}
	public void setSubscribedEvents(Set<EventPojo> subscribedEvents) {
		this.subscribedEvents = subscribedEvents;
	}
}