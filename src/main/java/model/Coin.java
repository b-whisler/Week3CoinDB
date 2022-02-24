/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 1, 2022
 */
package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.CountryHelper;

@Entity
@Table(name="coins")
public class Coin {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY_ID")
	private int countryid;
	@Column(name="YEAR")
	private int year;
	@Column(name="DENOMINATION")
	private String denomination;
	
	public Coin() {
		
	}

	public Coin(int countryid, int year, String denomination) {
		this.countryid = countryid;
		this.year = year;
		this.denomination = denomination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryId() {
		return countryid;
	}

	public void setCountryId(int countryid) {
		this.countryid = countryid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getCoinInfo() {
		return this.countryid + " - " + this.year + " - " + this.denomination;
	}
	
	public String getFullCoinInfo() {
		return "ID: " + this.id + " | Country: " + this.countryid + " | Year: " + this.year + " | Denomination: " + this.denomination;
	}
	
	public Country getCountry() {
		CountryHelper ch = new CountryHelper();
		return ch.getCountryById(countryid);
	}
	
}
