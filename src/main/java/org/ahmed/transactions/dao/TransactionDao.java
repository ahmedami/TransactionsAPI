package org.ahmed.transactions.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ahmed.transactions.database.DataBaseRepresentation;
import org.ahmed.transactions.entity.Transaction;

public class TransactionDao {
	private Map<Long , Transaction> transactions = DataBaseRepresentation.getTransactions();
	
	public Transaction getTransaction (Long transactionId){
		return transactions.get(transactionId);
	}
	
	public void addTransaction (Transaction transaction){
		transactions.put(transaction.getId(), transaction);
		
	}
	
	public boolean findById(Long transactionId){
		return transactions.containsKey(transactionId);
	}
	
	public void updateTransaction(Transaction transaction){
		String type = transaction.getType();
		double amount = transaction.getAmount();
		Long parentId = transaction.getParentId();
		Transaction oldTransaction= transactions.get(transaction.getId());
		if (type!= null && !type.isEmpty()){
			oldTransaction.setType(type);
		}
		if(amount!=0.0d){
			oldTransaction.setAmount(amount);
		}
		if(parentId!=null){
			oldTransaction.setParentId(parentId);
		}
	}
	
	public String getTypeName(Long transactionId){
		return transactions.get(transactionId).getType();
	}
	
	public static void main (String[]args){
		Set<Long> transactionsIds= new HashSet<>();
		System.out.println(transactionsIds.size());
	}
}
