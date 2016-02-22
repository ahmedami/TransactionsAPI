package org.ahmed.transactions.entity;

import java.util.HashSet;
import java.util.Set;

public class TransactionTree {
	public TransactionTree() {
		super();
	}
	
	public TransactionTree(Long id) {
		super();
		this.id = id;
	}

	private Long id;
	private Set<Long> childsIds = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Long> getChildsIds() {
		return childsIds;
	}
	
}
