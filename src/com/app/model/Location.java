package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOC_TAB")
public class Location {
	@Id
	@Column(name="l_id")
	@GeneratedValue(generator="xyz",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="xyz",sequenceName="LOC_SEQ")
	private int locId;
	@Column(name="l_name")
	private String locName;
	@Column(name="l_type")
	private String locType;
	
	//alt+Shift+S O (de-select all)
	public Location() {
	}
	//Alt+Shift+S O (select id only)

	public Location(int locId) {
		this.locId = locId;
	}
	public Location(int locId, String locName, String locType) {
		super();
		this.locId = locId;
		this.locName = locName;
		this.locType = locType;
	}
	//Alt+Shift+S R (select-all)

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}
	//toString -Alt+Shift+S S

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + "]";
	}
	//hashcode and equals methods
	//alt+Shift+S  H

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + locId;
		result = prime * result + ((locName == null) ? 0 : locName.hashCode());
		result = prime * result + ((locType == null) ? 0 : locType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locId != other.locId)
			return false;
		if (locName == null) {
			if (other.locName != null)
				return false;
		} else if (!locName.equals(other.locName))
			return false;
		if (locType == null) {
			if (other.locType != null)
				return false;
		} else if (!locType.equals(other.locType))
			return false;
		return true;
	}
	
	
	
}



