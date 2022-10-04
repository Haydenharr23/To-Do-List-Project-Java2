package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Task;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TaskList");

	public void insertItem(Task li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Task> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<Task> allItems = em.createQuery("SELECT i FROM Task i").getResultList();
		return allItems;
	}

	public void deleteItem(Task toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery(
				"select li from Task li where li.name = :selectedName and li.day = :selectedDay",
				Task.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedDay", toDelete.getDay());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Task result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Task searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Task found = em.find(Task.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Task toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Task> searchForItemByStore(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery("select li from Tasl li where li.name = :selectedName", Task.class);
		typedQuery.setParameter("selectedName", name);

		List<Task> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Task> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Task> typedQuery = em.createQuery("select li from Task li where li.day = :selectedDay", Task.class);
		typedQuery.setParameter("selectedItem", itemName);

		List<Task> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}
