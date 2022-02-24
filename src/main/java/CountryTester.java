import controller.CountryHelper;
import model.Country;

/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */

public class CountryTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Country us = new Country("United States", "Dollar");
		CountryHelper ch = new CountryHelper();
		ch.addCountry(us);
		System.out.println(ch.getAllCountries().get(0).getCountryCoins());
	}

}
