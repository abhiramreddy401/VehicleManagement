package edu.abhi.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.vo.ViolationVO;
@Repository("ViolationDao")
public class ViolationDaoImpl implements ViolationDao {
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 
	 	@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<Object[]> findbyWhere(String where) throws java.lang.Exception {
	
	 		Query query = null;
			if(where != null)
			query = entityManager.createNativeQuery("SELECT max(violation_count),violation_date FROM parking_violation o WHERE " + where);
				List<Object[]> resultList = query.getResultList();
				return resultList;
			
			
		}


		@Override
		@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
		public void save(ViolationVO carsnikParkingViolationVO) {
			// TODO Auto-generated method stub
			entityManager.persist(carsnikParkingViolationVO);
    	   	entityManager.flush();
		}


		@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<ViolationVO> findbyId(String where)
				throws Exception {
			// TODO Auto-generated method stub
			Query query = null;
			System.out.println("FROM CarsnikParkingViolationVO o WHERE " + where);
			if(where != null)
			query = entityManager.createQuery("FROM CarsnikParkingViolationVO o WHERE " + where);
			return query.getResultList();
	 	
		}

	 	@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<ViolationVO> findViolationsCount(String where)
				throws Exception {
			// TODO Auto-generated method stub
	 		Query query = null;
			System.out.println("select * from parking_violation where (violation_date between  DATE_FORMAT(NOW() ,'%Y-%m-01') AND NOW() ) and vio_user_id='"+where+"'");
	 		if(where != null)
			query = entityManager.createNativeQuery("select * from parking_violation where (violation_date between  DATE_FORMAT(NOW() ,'%Y-%m-01') AND NOW() ) and vio_user_id='"+where+"'");

			return  query.getResultList();
			
		}


		@Override
		@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
		public void updateVehicle(
				ViolationVO carsnikParkingViolationVO)
				throws Exception {
			// TODO Auto-generated method stub
			entityManager.merge(carsnikParkingViolationVO);	
		}
	 	
		
		

}
;