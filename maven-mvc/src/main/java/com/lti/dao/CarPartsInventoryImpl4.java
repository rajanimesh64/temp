package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CarPart;

@Component("carParts4")
public class CarPartsInventoryImpl4  implements CarPartsInventory{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}
	public List<CarPart> getAvailableParts() {
		Query q= entityManager.createQuery("select cp from CarPart as cp");		
		List<CarPart> list=q.getResultList();
		return list;
	}
}
