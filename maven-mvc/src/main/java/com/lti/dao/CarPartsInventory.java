package com.lti.dao;

import java.util.List;

import com.lti.entity.CarPart;

public interface CarPartsInventory {
	
	public void addNewPart(CarPart carPart);
	public  List<CarPart> getAvailableParts();


}
