package org.rent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.rent.model.enums.Gender;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement	
@Entity
@Table(name = "User")
@NamedQueries({@NamedQuery(name=User.GET_USERS_LIST,query="select u from User u"),
	           @NamedQuery(name=User.GET_USER_BY_ID,query="select u from User u where u.userId=:userId"),
	           @NamedQuery(name=User.GET_USER_BY_EMAIL,query="select u from User u where u.emailId=:emailId"),
	           @NamedQuery(name=User.GET_BY_EMAIL_AND_PWD,query="select u from User u where u.emailId=:emailId and u.password=:password")})
public class User implements Serializable{
	private static final long serialVersionUID = -1661527419693036326L;
	
	public static final String GET_USERS_LIST = "User.getUserList";
	public static final String GET_USER_BY_ID = "User.getUserById";
	public static final String GET_BY_EMAIL_AND_PWD = "User.getByEmailAndPwd";
	public static final String GET_USER_BY_EMAIL = "User.getByEmailId";
		
	@JsonIgnore
	@Column(name = "password",length=25)
	private String password;
	
	@JsonIgnore
	@XmlTransient
	@Column(name = "new_password",length=25)
	private String newPassword;
	
	@Column(name = "email_id",unique=true,length=25)
	private String emailId;
	
	@Column(name = "first_name",length=25)
	private String firstName;
	

	@Column(name = "last_name",length=25)
	private String lastName;
	
	@Column(name = "mobile_number",unique=true,length=10)
	private Long mobileNumber; 
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender")
	private Gender gender=Gender.MALE;
	
	@Column(name = "created_date")
	private Date createdDate=new Date(); 
	
	@Column(name = "updated_date")
	private Date updatedDate=new Date(); 
	
	@Column(name = "active")
	private Boolean active=true;
	
	@Column(name = "subscribe")
	private Boolean subscribe=true;
	
	
	@Column(name = "profile_image")
	private String profileImage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer userId;
	

	/** The role. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="role_id")
	private Role role;

	public User(Integer userId) {
		super();
		this.userId = userId;
	}
	public User() {
		super();
	}
	
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
