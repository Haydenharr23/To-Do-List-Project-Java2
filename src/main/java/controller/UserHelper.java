package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;


/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 6, 2022
 */
public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskList");

	public void insertUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<User> showAllUsers(){
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT s FROM User s").getResultList();
		return allUsers;
	}
	public User findUser(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select sh from User sh where sh.userName = :selectedName",User.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		User foundUser;
		try {
			foundUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundUser = new User(nameToLookUp);
		}
		em.close();

		return foundUser;
	}
}
