package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAcc {
	@Id
	@SequenceGenerator(initialValue = 12345, allocationSize = 1, sequenceName = "accno", name="accno")
	@GeneratedValue(generator = "accno") // it is used to generator number randomly
	long accNumber;
	
	String accType;
	
	double accLimit;
	
	boolean status;
	
	double amount;
	
	// many to one mapping done 
	@ManyToOne
	Customer customer;
	
	
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccLimit() {
		return accLimit;
	}
	public void setAccLimit(double accLimit) {
		this.accLimit = accLimit;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
