package com.debatecontest.pack.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.debatecontest.pack.model.Student;
import com.debatecontest.pack.service.StudentService;

@Repository
public class StudentImplementation implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Student> findAll() {
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Transactional
	public Student findById(int studentId) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, studentId);
		transaction.commit();
		return student;
	}

	@Transactional
	public void save(Student student) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
	}

	@Transactional
	public void deleteById(int studentId) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, studentId);
		session.delete(student);
		transaction.commit();
	}

}
