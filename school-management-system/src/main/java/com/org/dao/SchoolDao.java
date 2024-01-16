package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.School;
import com.org.dto.School;
import com.org.utilities.Helper;

public class SchoolDao {

	
	public void saveAndUpdate(School s)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	public List<School> fetchSchoolByEmailPassword(String email,String password) {
		EntityManagerFactory emf=Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="SELECT p from School p where p.email=?1 and p.password=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<School> schools=query.getResultList();
		return schools;
	}
	
	public List<School> fetchAllSchools()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="select s from School s";
		
		Query query = em.createQuery(jpql);
		
		List<School> schools=query.getResultList();
		return schools;
		
	}
	
	public School fetchSchoolById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		 return em.find(School.class, id);
	}
	
	public List<School> fetchSchoolByEmail(String email) {
		EntityManagerFactory emf=Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="SELECT p from School p where p.email=?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		List<School> schools=query.getResultList();
		return schools;
	}

}
