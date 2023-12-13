package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}

//	for email or phone number validation
	public List<Customer> check(String email, long mobile) {

		// Method - 1
		List<Customer> list = entityManager.createQuery("select z from Customer z where email=?1 and mobile=?2")
				.setParameter(1, email)
				.setParameter(2, mobile)
				.getResultList();

		// method - 2
		// Query query = entityManager.createQuery("select z from Customer z where
		// email=?1 and mobile=2?");
		// query.setParameter(1, email);
		// query.setParameter(2, mobile);
		// List<Customer> list = query.getResultList();
		return list;

	}

}
