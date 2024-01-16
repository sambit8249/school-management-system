package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.School;
import com.org.dto.Student;
import com.org.utilities.Helper;

public class StudentDao {
	
	
	public void saveAndUpdate(Student student)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(student);
		et.commit();
	}
	public List<Student> fetchStudentByEmailPassword(String email,String password) {
		EntityManagerFactory emf=Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="SELECT p from Student p where p.email=?1 and p.password=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Student> students=query.getResultList();
		return students;
	}
	
	public List<Student> fetchAllStudents()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="select s from Student s";
		
		Query query = em.createQuery(jpql);
		
		List<Student> students=query.getResultList();
		return students;
		
	}
	
	public Student fetchStudentById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		 return em.find(Student.class, id);
	}
	

	public List<Student> fetchStudentByEmail(String email) {
		EntityManagerFactory emf=Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql="SELECT s from Student s where s.email=?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		List<Student> students=query.getResultList();
		return students;
	}


}
