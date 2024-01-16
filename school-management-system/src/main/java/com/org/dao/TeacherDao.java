package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.School;
import com.org.dto.Student;
import com.org.dto.Teacher;
import com.org.utilities.Helper;

public class TeacherDao {

	public void saveAndUpdate(Teacher teacher) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(teacher);
		et.commit();
	}

	public List<Teacher> fetchTeacherByEmailPassword(String email, String password) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT p from Teacher p where p.email=?1 and p.password=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Teacher> teachers = query.getResultList();
		return teachers;
	}

	public List<Teacher> fetchAllTeachers() {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Teacher s";

		Query query = em.createQuery(jpql);

		List<Teacher> teachers = query.getResultList();
		return teachers;

	}

	public Teacher fetchTeacherById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		return em.find(Teacher.class, id);
	}

	public List<Teacher> fetchTeacherByEmail(String email) {
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "SELECT t from Teacher t where t.email=?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		List<Teacher> teachers = query.getResultList();
		return teachers;
	}

}
