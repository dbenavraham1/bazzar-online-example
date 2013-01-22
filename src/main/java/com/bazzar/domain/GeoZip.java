package com.bazzar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bazzar.domain.lookup.StateTypeLookup;

@Entity
@Table(name="ZipCodes")
public class GeoZip extends DBBase {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private long id;
	@Column(name="zip")
	private String zip;
	@Column(name="City")
	private String city;
	@ManyToOne
	@JoinColumn (name="state")
	private StateTypeLookup state;
	@Column(name="latitude")
	private double latitude;
	@Column(name="longitude")
	private double longitude;
	@Column(name="timezone")
	private int timezone;
	@Column(name="dst")
	private boolean dayLighSaving;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateTypeLookup getState() {
		return state;
	}
	public void setState(StateTypeLookup state) {
		this.state = state;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getTimezone() {
		return timezone;
	}
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	public boolean isDayLighSaving() {
		return dayLighSaving;
	}
	public void setDayLighSaving(boolean dayLighSaving) {
		this.dayLighSaving = dayLighSaving;
	}
	
}
