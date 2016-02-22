package org.ahmed.transactions.service;

import org.ahmed.transactions.dao.TransactionDao;
import org.ahmed.transactions.dao.TransactionTreeDao;
import org.ahmed.transactions.dto.SumDto;
import org.ahmed.transactions.dto.TransactionDto;
import org.ahmed.transactions.entity.Transaction;
import org.ahmed.transactions.entity.TransactionTree;
import org.ahmed.transactions.exception.DataNotFoundException;

public class TransactionTreeService {
	
	TransactionTreeDao transactionTreeDao = new TransactionTreeDao();
	TransactionDao transactionDao = new TransactionDao();
	
	public SumDto getSum(Long parentId){
		double sum = 0.0d;
		TransactionTree transactionTree = transactionTreeDao.getTransactionTree(parentId);
		if(transactionTree == null) return null;
		for(Long transactionId: transactionTree.getChildsIds()){
			sum += getTransaction(transactionId).getAmount();
		}
		sum += getTransaction(parentId).getAmount();
		return new SumDto(sum);
	}
	
	public void addTransactionTree(Long parentId){
		if(!transactionTreeDao.findTransactionTreeByParentId(parentId)){
			transactionTreeDao.addTransactionTree(new TransactionTree(parentId));
		}
	}
	
	public void updateTransactionTree(Long parentId,Long childId){
		if(!transactionTreeDao.findTransactionTreeByParentId(parentId)){
			addTransactionTree(parentId);
		}
		if(parentId!=childId)
			transactionTreeDao.getTransactionTree(parentId).getChildsIds().add(childId);
	}
	
	public TransactionDto getTransaction(Long transactionId){
		if(transactionDao.findById(transactionId)){
			Transaction transaction = transactionDao.getTransaction(transactionId);
			return ConversionService.getTransactionDtoFromTransaction(transaction);
		}
		else {
			throw new DataNotFoundException("Data Not Found for That Id, Please Check your inputs");
		}		
	}
}
