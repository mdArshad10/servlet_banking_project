package dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@SequenceGenerator(initialValue = 11223344, allocationSize = 1, sequenceName = "cusid", name = "cusid")
	@GeneratedValue(generator = "cusid")
	// here this annotation will be used to 
	int cid;
	 
//	@Column(nullable=false)
	String cname;
	
//	@Column(nullable=false, unique = true)
	String email;
	
//	@Column(nullable=false)
	String password;
	
//	@Column(nullable = false, unique = true)
	long mobile;
	
//	@Column(nullable = false)
	String gender;
	
	//	date of birth
	Date dob;

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
	
	
	
}
