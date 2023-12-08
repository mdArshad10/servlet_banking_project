package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	int cid;
	String cname;
	String email;
	String password;
	long mobile;
	
}
