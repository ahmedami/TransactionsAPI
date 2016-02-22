package org.ahmed.transactions.entity;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


public class Type {
	
	private String name;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
