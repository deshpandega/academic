/**
 * 
 */
package com.neu.gd.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author GD
 *
 */
@NamedQuery(name="events.loadAll",query="FROM EventPojo")
@Entity
@Table(name="event_table")
public class EventPojo extends AddressPojo{
	@Column(name="eventName")
	private String eventName;
	
	@Column(name="eventDescription")
	private String eventDescription;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="eventDate")
//	private Date eventDate;
	private String eventDate;
	
	@Column(name="eventTime")
	private String eventTime;
	//private Set
	
	@Column(name="imagePath")
	private String imagePath;
	
	@Transient
	private MultipartFile eventPhoto;
	
	@Transient
	private Date dateOfEvent;
	
	@ManyToOne
	@JoinColumn(name = "neuID")
	private LoginPojo user;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<LoginPojo> subscribers;
	
	public EventPojo() {
		this.subscribers = new HashSet<LoginPojo>();
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
//	public Date getEventDate() {
//		return eventDate;
//	}
//	public void setEventDate(Date eventDate) {
//		this.eventDate = eventDate;
//	}
	
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventDate() {
		return eventDate;
	}
	
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventTime() {
		return eventTime;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public MultipartFile getEventPhoto() {
		return eventPhoto;
	}
	public void setEventPhoto(MultipartFile eventPhoto) {
		this.eventPhoto = eventPhoto;
	}

	public LoginPojo getUser() {
		return user;
	}
	public void setUser(LoginPojo user) {
		this.user = user;
	}

	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}

	public Set<LoginPojo> getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(Set<LoginPojo> subscribers) {
		this.subscribers = subscribers;
	}
	
	public void addSubscriber(LoginPojo user) {
        subscribers.add( user );
        user.getSubscribedEvents().add( this );
    }

    public void removeSubscriber(LoginPojo user) {
    	subscribers.remove( user );
    	user.getSubscribedEvents().remove( this );
    }
}