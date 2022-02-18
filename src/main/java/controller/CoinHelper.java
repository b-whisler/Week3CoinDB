/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Feb 1, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Coin;

public class CoinHelper {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Coins");
	
	public void addCoin(Coin co) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(co);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeCoin(Coin toRemove) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery	= em.createQuery("select co from Coin co where co.id = :selectedId", Coin.class);
		typedQuery.setParameter("selectedId", toRemove.getId());
		typedQuery.setMaxResults(1);
		Coin result	= typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public List<Coin> getAllCoins(){
		EntityManager em = emFactory.createEntityManager();
		List<Coin> allItems	= em.createQuery("SELECT i FROM Coin i").getResultList();
		return allItems;
		}
	
	public List<Coin> searchForCoinByCountry(String countryName) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select co from Coin co where co.country = :selectedCountry", Coin.class);
		typedQuery.setParameter("selectedCountry", countryName);
		List<Coin> foundCoins = typedQuery.getResultList();
		em.close();
		return foundCoins;
	}
	
	public List<Coin> searchForCoinByYear(String coinYear) {
		EntityManager	em	=	emFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery	= em.createQuery("select co from Coin co where co.year = :selectedYear", Coin.class);
		typedQuery.setParameter("selectedYear",	coinYear);
		List<Coin> foundCoins = typedQuery.getResultList();
		em.close();
		return foundCoins;
	}
	
	public Coin getCoinById(int idToFind) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		Coin result	= em.find(Coin.class, idToFind);
		em.close();
		return result;
	}
	
	public void editCoin (Coin toEdit)	{
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emFactory.close();
		}
}
