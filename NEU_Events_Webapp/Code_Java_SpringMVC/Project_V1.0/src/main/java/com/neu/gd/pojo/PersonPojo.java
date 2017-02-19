/**
 * 
 */
package com.neu.gd.pojo;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author GD
 *
 */
@Entity
@Table(name="person_table")
public class PersonPojo {
	
	@Id
	private String neuID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neuID")
	private LoginPojo login;
	
	public PersonPojo() {
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getNeuID() {
		return neuID;
	}
	public void setNeuID(String neuID) {
		this.neuID = neuID;
	}

	public LoginPojo getLogin() {
		return login;
	}
	public void setLogin(LoginPojo login) {
		this.login = login;
	}
}
