package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@SequenceGenerator(initialValue = 11223344, allocationSize = 1, sequenceName = "cusid", name = "cusid")
	@GeneratedValue(generator = "cusid")
	// here this annotation will be used to 
	int cid;
	 
	String cname;
	
	String email;
	
	String password;
	
	long mobile;
	
	String gender;
	
	Date dob;
	
	// mapping having done 
	@OneToMany
	List<BankAcc> bankAccounts;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<BankAcc> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAcc> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	
	
}
