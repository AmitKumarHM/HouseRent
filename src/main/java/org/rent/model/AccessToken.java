package org.rent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
@Entity
@Table(name = "Access_Token")
public class AccessToken implements Serializable{

	private static final long serialVersionUID = -3703435724533495798L;

	@Column(name = "access_token")
	private String accessToken;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer accessTokenId;
	
	@Column(name = "refresh_token")
	private String refreshToken;
	
	@Column(name = "valid_to")
	private Long validTo;
	
	@Column(name = "created_date")
	private Date createdDate;

	/** The user. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getAccessTokenId() {
		return accessTokenId;
	}

	public void setAccessTokenId(Integer accessTokenId) {
		this.accessTokenId = accessTokenId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getValidTo() {
		return validTo;
	}

	public void setValidTo(Long validTo) {
		this.validTo = validTo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
	
}
