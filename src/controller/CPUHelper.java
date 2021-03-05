package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CPU;
import model.Computer;

public class CPUHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ComputerSpecsWeb");
	
	public void insertCPU(CPU cpu)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cpu);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCPU(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CPU target = em.find(CPU.class, index);
		em.remove(target);
		em.getTransaction().commit();
		em.close();
	}
	
	public CPU searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CPU retrieved = em.find(CPU.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateCPU(CPU cpu)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(cpu);
		em.getTransaction().commit();
		em.close();
	}
	public List<CPU> showCPUs()
	{
		EntityManager em = emfactory.createEntityManager();
		List<CPU> allCPUs = em.createQuery("SELECT cpu FROM CPU cpu").getResultList();
		return allCPUs;
	}
	public CPU searchByName(String name)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CPU> typedQuery = em.createQuery("select cpu from CPU cpu where cpu.name = :selectedName", CPU.class);
		typedQuery.setParameter("selectedName", name);
		CPU foundCPU;
		foundCPU = typedQuery.getSingleResult();
		em.close();
		return foundCPU;
	}
	
	public void clean()
	{
		emfactory.close();
	}
}
