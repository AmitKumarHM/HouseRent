package org.rent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.rent.model.enums.City;
import org.rent.model.enums.Country;
import org.rent.model.enums.State;

@XmlRootElement	
@Entity
@Table(name = "Address")
public class Address implements Serializable {

	private static final long serialVersionUID = -3078464140818944558L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer addressId;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "house_number")
	private String houseNumber;
	
	@Column(name = "pincode")
	private Integer pincode;
	
	@Column(name = "lat")
	private Double lat;
	
	@Column(name = "lng")
	private Double lng;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "city")
	private City city;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "country")
	private Country country;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private State state;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
