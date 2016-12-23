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
@Table(name = "Furnished")
public class Furnished implements Serializable {

	private static final long serialVersionUID = 6550311806182597947L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer furnishedId;
	
	@Column(name = "bed",length=2)
	private Integer bed;
	
	@Column(name = "bathroom",length=2)
	private Integer bathroom;
	
	@Column(name = "is_tv")
	private Boolean isTV;
	
	@Column(name = "is_refrigerator")
	private Boolean isRefrigerator;
	
	@Column(name = "is_washing")
	private Boolean isWashing;
	
	@Column(name = "is_wifi")
	private Boolean isWifi;
	
	@Column(name = "is_kitchen")
	private Boolean isKitchen;
	
	@Column(name = "created_date")
	private Date createdDate=new Date(); 
	
	@Column(name = "updated_date")
	private Date updatedDate=new Date();
	
	
	public Integer getFurnishedId() {
		return furnishedId;
	}

	public void setFurnishedId(Integer furnishedId) {
		this.furnishedId = furnishedId;
	}

	public Integer getBed() {
		return bed;
	}

	public void setBed(Integer bed) {
		this.bed = bed;
	}

	public Integer getBathroom() {
		return bathroom;
	}

	public void setBathroom(Integer bathroom) {
		this.bathroom = bathroom;
	}

	public Boolean getIsTV() {
		return isTV;
	}

	public void setIsTV(Boolean isTV) {
		this.isTV = isTV;
	}

	public Boolean getIsRefrigerator() {
		return isRefrigerator;
	}

	public void setIsRefrigerator(Boolean isRefrigerator) {
		this.isRefrigerator = isRefrigerator;
	}

	public Boolean getIsWashing() {
		return isWashing;
	}

	public void setIsWashing(Boolean isWashing) {
		this.isWashing = isWashing;
	}

	public Boolean getIsWifi() {
		return isWifi;
	}

	public void setIsWifi(Boolean isWifi) {
		this.isWifi = isWifi;
	}

	public Boolean getIsKitchen() {
		return isKitchen;
	}

	public void setIsKitchen(Boolean isKitchen) {
		this.isKitchen = isKitchen;
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
