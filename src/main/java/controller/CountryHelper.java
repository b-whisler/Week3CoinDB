/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Coin;
import model.Country;


public class CountryHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Coins");
	
	
	public void addCountry(Country c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		}
	
	public void removeCountry(Country c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery("select cn from Country cn where cn.id = :selectedId", Country.class);
		typedQuery.setParameter("selectedId", c.getId());
		typedQuery.setMaxResults(1);
		Country result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Country> getAllCountries(){
		EntityManager em = emfactory.createEntityManager();
		List<Country> allCountries = em.createQuery("SELECT c FROM Country c").getResultList();
		return allCountries;
		}
	
	public void updateCountryCoins(Country c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CoinHelper ch = new CoinHelper();
		//c.setCountryCoins(ch.searchForCoinByCountry(c.getName()));
		c.setCountryCoins(getCoinsOfCountry(c));
		//System.out.println(c.getCountryCoins().toString());
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Country getCountryByName(String countryName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Country> typedQuery = em.createQuery("select cn from Country cn where cn.name = :selectedName", Country.class);
		typedQuery.setParameter("selectedName", countryName);
		Country result = typedQuery.getResultList().get(0);
		em.close();
		return result;
	}
	
	public Country getCountryById(int idToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Country result = em.find(Country.class, idToFind);
		em.close();
		return result;
	}
	
	public List<Coin> getCoinsOfCountry(Country c){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select c from Coin c where c.country = :selectedId", Coin.class);
		typedQuery.setParameter("selectedId", c);
		List<Coin> result = typedQuery.getResultList();
		em.close();
		return result;
	}
}
