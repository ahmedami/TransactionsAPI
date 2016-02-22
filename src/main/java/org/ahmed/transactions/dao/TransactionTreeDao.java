package org.ahmed.transactions.dao;

import java.util.Map;

import org.ahmed.transactions.database.DataBaseRepresentation;
import org.ahmed.transactions.entity.TransactionTree;

public class TransactionTreeDao {
	private Map<Long,TransactionTree> transactionsTrees = DataBaseRepresentation.getTransactionsTrees();
	
	public TransactionTree getTransactionTree(Long parentId){
		return transactionsTrees.get(parentId);
	}
	
	public void addTransactionTree(TransactionTree transactionTree){
		transactionsTrees.put(transactionTree.getId(), transactionTree);
	}
	
	public boolean findTransactionTreeByParentId(Long parentId){
		return transactionsTrees.containsKey(parentId);
	}
}
