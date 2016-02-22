package org.ahmed.transactions.entity;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


public class Type {
	
	private transient String name;
	private Set<Long> transactionsIds= new HashSet<>();
	
	public Type(String name, Long transactionId) {
		super();
		this.name = name;
		this.transactionsIds.add(transactionId);
	}
	public Type() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Long> getTransactionsIds() {
		return transactionsIds;
	}	
	
}
