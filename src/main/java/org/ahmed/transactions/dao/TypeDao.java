package org.ahmed.transactions.dao;

import java.util.Map;

import org.ahmed.transactions.database.DataBaseRepresentation;
import org.ahmed.transactions.entity.Type;

public class TypeDao {
	private Map<String,Type> types = DataBaseRepresentation.getTypes();
	
	public Type getTypes(String typeName){
		return types.get(typeName);
	}
	
	public void addType(Type type){
		types.put(type.getName(), type);
	}
	
	public boolean findByName(String typeName){
		return types.containsKey(typeName);
	}
	
}
