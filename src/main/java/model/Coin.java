/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 1, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coins")
public class Coin {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="YEAR")
	private int year;
	@Column(name="DENOMINATION")
	private String denomination;
	
	public Coin() {
		
	}

	public Coin(String country, int year, String denomination) {
		this.country = country;
		this.year = year;
		this.denomination = denomination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
		return this.country + " - " + this.year + " - " + this.denomination;
	}
	
	public String getFullCoinInfo() {
		return "ID: " + this.id + " | Country: " + this.country + " | Year: " + this.year + " | Denomination: " + this.denomination;
	}
	
}
