package org.ahmed.transactions.service;

import java.util.ArrayList;
import java.util.List;

import org.ahmed.transactions.dao.TypeDao;
import org.ahmed.transactions.entity.Type;
import org.ahmed.transactions.exception.DataNotFoundException;

public class TypeService {
	TypeDao typeDao = new TypeDao();
	
	public List<Long> getTransactionsByType(String typeName){
		List<Long> transactionsIds ;
		if(findTypeByName(typeName)){
			Type type = typeDao.getTypes(typeName);
			transactionsIds = ConversionService.getTypeDtoFromType(type);
		}
		else {
			throw new DataNotFoundException("Data Not Found for That Type, Please Check your inputs");
		}
		return transactionsIds;
	}
	
	public Type getType(String typeName){
		Type type = typeDao.getTypes(typeName);
		return (type==null)?new Type(): type;
	}
	
	void addType(String typeName, Long transactionId){
		typeDao.addType(new Type(typeName, transactionId));
	}
	
	void updateType(String typeName, Long transactionId){
		if(findTypeByName(typeName)){
			if(!findTransactionInType(typeName, transactionId)){
				typeDao.getTypes(typeName).getTransactionsIds().add(transactionId);
			}
			else {
				typeDao.getTypes(typeName).getTransactionsIds().remove(transactionId);
			}
		}
		else {
			addType(typeName, transactionId);
		}
	}
	
	boolean findTransactionInType(String typeName, Long transactionId){
		return typeDao.getTypes(typeName).getTransactionsIds().contains(transactionId);
	}
	
	boolean findTypeByName(String typeName){
		if(typeName==null||typeName.isEmpty())
			return false;
		return typeDao.findByName(typeName);
	}
}
