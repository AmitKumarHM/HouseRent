package org.rent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
@Entity
@Table(name = "Amenties")
public class Amenties implements Serializable {

	private static final long serialVersionUID = -4090191758068336186L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer amentiesId;

	@Column(name = "security",length=25)
	private String security;
	
	@Column(name = "school",length=50)
	private String school;
	
	@Column(name = "hospital",length=50)
	private String hospital;
	
	@Column(name = "parking",length=25)
	private String parking;
	
	@Column(name = "petrol_pump",length=50)
	private String petrolPump;
	
	@Column(name = "grocery",length=50)
	private String grocery;
	
	@Column(name = "created_date")
	private Date createdDate=new Date(); 
	
	@Column(name = "updated_date")
	private Date updatedDate=new Date();

	public Integer getAmentiesId() {
		return amentiesId;
	}

	public void setAmentiesId(Integer amentiesId) {
		this.amentiesId = amentiesId;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getPetrolPump() {
		return petrolPump;
	}

	public void setPetrolPump(String petrolPump) {
		this.petrolPump = petrolPump;
	}

	public String getGrocery() {
		return grocery;
	}

	public void setGrocery(String grocery) {
		this.grocery = grocery;
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
	
}
