package org.ahmed.transactions.facade;

import java.util.List;

import org.ahmed.transactions.dto.*;
import org.ahmed.transactions.entity.Type;
import org.ahmed.transactions.exception.DataNotFoundException;
import org.ahmed.transactions.service.TransactionService;
import org.ahmed.transactions.service.TransactionTreeService;
import org.ahmed.transactions.service.TypeService;

public class FacadeService {
	TransactionService transactionService = new TransactionService();
	TransactionTreeService transactionTreeService = new TransactionTreeService();
	TypeService typeService = new TypeService();
	
	public Response addTransaction (Long transactionId, TransactionDto transactionDto){
			transactionService.addTransaction(transactionId, transactionDto);
			return new Response(Response.STATUS_OK);
	}
	
	public TransactionDto getTransaction(Long transactionId){
		return transactionService.getTransaction(transactionId);
	}
	
	public List<Long> getTransactionsByType(String typeName){
		return typeService.getTransactionsByType(typeName);
	}
	
	public SumDto getSum(Long parentId){
		SumDto sumDto = transactionTreeService.getSum(parentId);
		if (sumDto == null){
			throw new DataNotFoundException("Data Not Found , Please Check your inputs");
		}
		return sumDto;
	}
	
}
