package org.ahmed.transactions.service;

import org.ahmed.transactions.dao.TransactionDao;
import org.ahmed.transactions.dto.TransactionDto;
import org.ahmed.transactions.entity.Transaction;
import org.ahmed.transactions.exception.*;

public class TransactionService {
	TransactionDao transactionDao = new TransactionDao();
	TypeService typeService = new TypeService();
	TransactionTreeService transactionTreeService = new TransactionTreeService();
	
	public void addTransaction(Long transactionId, TransactionDto transactionDto){
		Transaction transaction= ConversionService.getTransactionFromTransactionDto(transactionId, transactionDto);
		if(!findTransactionById(transactionId)){
			if(transaction.getType()==null||transaction.getType().isEmpty()||transaction.getAmount()==0.0d)
				throw new DataValidationException("Some Data Not Valid or missing, Please Check your inputs");
		transactionDao.addTransaction(transaction);
		transactionTreeService.addTransactionTree(transactionId);
		if(transaction.getParentId()!=0)
			transactionTreeService.updateTransactionTree(transaction.getParentId(), transactionId);
		typeService.updateType(transaction.getType(), transactionId);
		}
		else {
			updateTransaction(transaction);
		}
	}
	
	public TransactionDto getTransaction(Long transactionId){
		if(findTransactionById(transactionId)){
			Transaction transaction = transactionDao.getTransaction(transactionId);
			return ConversionService.getTransactionDtoFromTransaction(transaction);
		}
		else {
			throw new DataNotFoundException("Data Not Found for That Id, Please Check your inputs");
		}		
	}
	
	private void updateTransaction(Transaction transaction){
		String typeName = transaction.getType();
		Long transactionId = transaction.getId();
		Long parentId = transaction.getParentId();
		String oldTypeName = transactionDao.getTypeName(transactionId);
		if(typeName!=null && !typeName.equals(oldTypeName)){
			typeService.updateType(typeName, transactionId);
			typeService.updateType(oldTypeName, transactionId);
		}
		if(parentId!=null||parentId!=0)
			transactionTreeService.updateTransactionTree(transaction.getParentId(), transactionId);
		transactionDao.updateTransaction(transaction);
	}
	
	private boolean findTransactionById(Long transactionId){
		return transactionDao.findById(transactionId);
	}
}
