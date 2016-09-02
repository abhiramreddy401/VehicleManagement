package edu.abhi.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.vo.EntryVO;
import edu.abhi.springmvc.vo.VehicleDetailsVO;

@Repository("VehicleRegisterDao")
public class VehicleRegisterDaoImpl implements VehicleRegisterDao{
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 @Override
	 @Transactional(readOnly=true)
	public void registerVehicle(
				VehicleDetailsVO vehicleDetailsVO)
				throws Exception {
			// TODO Auto-generated method stub
		 	entityManager.persist(vehicleDetailsVO);
		   	entityManager.flush();
			
		}
	
	@Override
	@Transactional(readOnly=true)
	public void updateVehicle(String assigned, int assignSlot) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional(readOnly=true)
	public VehicleDetailsVO findById(String where)  {
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM VehicleDetailsVO o WHERE " + where);
		 return (VehicleDetailsVO) query.getResultList().get(0);
		 
		 //return  (VehicleDetailsVO)entityManager.find(VehicleDetailsVO.class, vehicleNumber);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<VehicleDetailsVO> findByWhere(String where) {
		// TODO Auto-generated method stub
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM VehicleDetailsVO o WHERE " + where);
		 return query.getResultList();
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(
			VehicleDetailsVO vehicleDetailsVO) {
		// TODO Auto-generated method stub
		   entityManager.merge(vehicleDetailsVO);	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<EntryVO> findByDate(String where)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM EntryVO o WHERE " + where);
		 return query.getResultList();
	
	}

	
}
