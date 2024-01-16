package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Principle;
import com.org.dto.School;
import com.org.utilities.Helper;

public class PrincipleDao {

	public void saveAndUpdate(Principle principle) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		School school = principle.getSchool();

		et.begin();
		em.merge(school);
		et.commit();
	}

	public List<Principle> fetchPrincipleByEmailPassword(String email, String password) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT p from Principle p where p.email=?1 and p.password=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Principle> principles = query.getResultList();
		return principles;
	}

	public List<Principle> fetchAllPrinciples() {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Principle s";

		Query query = em.createQuery(jpql);

		List<Principle> principles = query.getResultList();
		return principles;

	}

	public Principle fetchPrincipleById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		return em.find(Principle.class, id);
	}

	public List<Principle> fetchPrincipleByEmail(String email) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT s from Principle s where s.email=?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		List<Principle> principles = query.getResultList();
		return principles;
	}

}