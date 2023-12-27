package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.BankAcc;
import dto.Customer;

public class BankDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(BankAcc bankAcc) {
		entityTransaction.begin();
		entityManager.persist(bankAcc);
		entityTransaction.commit();
	}

	public BankAcc fetchBankDetail(long accNumber) {
		BankAcc bankAcc = entityManager.find(BankAcc.class, accNumber);
		return bankAcc;
	}
	
	public void updateAccountDetail(BankAcc bankAcc) {
		entityTransaction.begin();
		entityManager.merge(bankAcc);
		entityTransaction.commit();
	}
}
