/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String currency;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.EAGER, orphanRemoval=true)
	private List<Coin> countryCoins;
	
	public Country() {
		
	}
	
	public Country(String name, String currency) {
		this.name = name;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Coin> getCountryCoins() {
		return countryCoins;
	}

	public void setCountryCoins(List<Coin> countryCoins) {
		this.countryCoins = countryCoins;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", currency=" + currency + ", countryCoins=" + countryCoins
				+ "]";
	}
	
	

}
