package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEN_TAB")
public class Vendor {
	@Id
	@Column(name="vid")
	private int venId;
	@Column(name="vname")
	private String venName;
	@Column(name="vmail")
	private String venMail;
	
	/**relation between
	 * location and vendor		
	 */
	@ManyToOne
	@JoinColumn(name="locId_fk")
	private Location loc;

	public Vendor() {
		super();
	}

	public Vendor(int venId) {
		super();
		this.venId = venId;
	}

	public Vendor(int venId, String venName, String venMail, Location loc) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venMail = venMail;
		this.loc = loc;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenMail() {
		return venMail;
	}

	public void setVenMail(String venMail) {
		this.venMail = venMail;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venMail="
				+ venMail + ", loc=" + loc + "]";
	}

	
}
