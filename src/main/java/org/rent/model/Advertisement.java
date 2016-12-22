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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
@Entity
@Table(name = "Advertisement")
@NamedQueries({@NamedQuery(name=Advertisement.GET_ADVERTISEMENT_BY_ID,query="select ad from Advertisement ad where ad.advertisementId=:advertisementId")})
public class Advertisement implements Serializable{

	public static final String GET_ADVERTISEMENT_BY_ID = "Adveristment.getById";
	private static final long serialVersionUID = 2052714789841969731L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer advertisementId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "created_date")
	private Date createdDate; 
	
	@Column(name = "updated_date")
	private Date updatedDate; 
	
	
	

	public Integer getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Furnished getFurnished() {
		return furnished;
	}

	public void setFurnished(Furnished furnished) {
		this.furnished = furnished;
	}

	public Required getRequired() {
		return required;
	}

	public void setRequired(Required required) {
		this.required = required;
	}

	public Amenties getAmenties() {
		return amenties;
	}

	public void setAmenties(Amenties amenties) {
		this.amenties = amenties;
	}

	/** The user. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	/** The Address. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="address_id")
	private Address address;
	
	/** The Furnished. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="furnished_id")
	private Furnished furnished ;

	/** The Required. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="required_id")
	private Required required;

	/** The Amenties. */
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="amenties_id")
	private Amenties amenties;

}
