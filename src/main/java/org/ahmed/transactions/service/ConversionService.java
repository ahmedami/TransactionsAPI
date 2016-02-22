package org.ahmed.transactions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ahmed.transactions.dto.TransactionDto;
import org.ahmed.transactions.entity.*;

public class ConversionService {
	
	static List<Long> getTypeDtoFromType(Type type){
		Set<Long> transactionsIds = type.getTransactionsIds(); 
		if(!transactionsIds.isEmpty())
			return new ArrayList<>(type.getTransactionsIds());
		else
			return new ArrayList<>();
	}
	
	static TransactionDto getTransactionDtoFromTransaction(Transaction transaction){
		return new TransactionDto(transaction.getType(),transaction.getAmount(),transaction.getParentId());
	}
	
	static Transaction getTransactionFromTransactionDto(Long transactionId, TransactionDto transactionDto){
		return new Transaction(transactionId, transactionDto.getType(), transactionDto.getAmount(), transactionDto.getParentId());
	} 

}
