package org.rent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.rent.model.enums.Gender;

@XmlRootElement	
@Entity
@Table(name = "Required")
public class Required implements Serializable {

	private static final long serialVersionUID = 7173596387295336737L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer requiredId;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "required_gender")
	private Gender requiredGender;
	
	@Column(name = "is_veg")
	private Boolean isVeg;
	
	@Column(name = "is_alcohol")
	private Boolean isAlcohol;
	
	@Column(name = "deposite")
	private Integer deposite;
	
	@Column(name = "rent")
	private Integer rent;
	
	@Column(name = "no_of_member")
	private Short noOfMember;

	@Column(name = "created_date")
	private Date createdDate; 
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	public Integer getRequiredId() {
		return requiredId;
	}

	public void setRequiredId(Integer requiredId) {
		this.requiredId = requiredId;
	}

	public Gender getRequiredGender() {
		return requiredGender;
	}

	public void setRequiredGender(Gender requiredGender) {
		this.requiredGender = requiredGender;
	}

	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	public Boolean getIsAlcohol() {
		return isAlcohol;
	}

	public void setIsAlcohol(Boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}

	public Integer getDeposite() {
		return deposite;
	}

	public void setDeposite(Integer deposite) {
		this.deposite = deposite;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Short getNoOfMember() {
		return noOfMember;
	}

	public void setNoOfMember(Short noOfMember) {
		this.noOfMember = noOfMember;
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
