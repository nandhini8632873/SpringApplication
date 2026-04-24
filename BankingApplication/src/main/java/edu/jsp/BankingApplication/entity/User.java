package edu.jsp.BankingApplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	private String name;
	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Loan> loans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Account> accounts;

	public void addLaon(Loan l) {
		loans.add(l);
		l.setUser(this);
	}

	public void removeLoan(Loan l) {
		loans.remove(l);
		l.setUser(null);
	}
	
	
	public void  addAccount(Account a) {
		accounts.add(a);
		a.setUser(this);
	}
	
	public void removeAccount(Account a) {
		accounts.remove(a);
		a.setUser(null);
	}
	
	

}
