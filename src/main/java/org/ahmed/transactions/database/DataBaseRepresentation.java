package org.ahmed.transactions.database;

import java.util.HashMap;
import java.util.Map;

import org.ahmed.transactions.entity.*;

public class DataBaseRepresentation {
	private static Map<Long , Transaction> transactions = new HashMap<>();
	private static Map<String,Type> types = new HashMap<>();
	private static Map<Long , TransactionTree> transactionsTrees = new HashMap<>();
	
	public static Map<Long, TransactionTree> getTransactionsTrees() {
		return transactionsTrees;
	}
	public static Map<Long, Transaction> getTransactions() {
		return transactions;
	}
	public static Map<String, Type> getTypes() {
		return types;
	}
	
}
