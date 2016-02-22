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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TransactionTree other = (TransactionTree) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
