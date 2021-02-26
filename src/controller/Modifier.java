/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Computer;

/** *@author logie - Logan Riedell
* CIS175 - Spring 2021
* Feb 11, 2021
*/
public class Modifier {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ComputerSpecsWeb");

	public void insertComputer(Computer com)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(com);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteComputer(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Computer target = em.find(Computer.class, index);
		em.remove(target);
		em.getTransaction().commit();
		em.close();
	}
	
	public Computer searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Computer retrieved = em.find(Computer.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateCom(Computer com)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(com);
		em.getTransaction().commit();
		em.close();
	}
	public List<Computer> showComputers()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Computer> allComputers = em.createQuery("SELECT com FROM Computer com").getResultList();
		return allComputers;
	}
	public void clean()
	{
		emfactory.close();
	}
}
