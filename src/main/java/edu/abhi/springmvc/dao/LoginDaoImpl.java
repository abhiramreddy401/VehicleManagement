package edu.abhi.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.vo.UsersVO;

@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao{
	
	
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 
 	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<UsersVO> findbyWhere(String where) throws java.lang.Exception {

 		Query query = null;
		if(where != null)
			query = entityManager.createQuery("FROM UsersVO o WHERE " + where);
		 return query.getResultList();
 		
 		
 		}


	 	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
		public void update(UsersVO usersVO)
				throws Exception {
			// TODO Auto-generated method stub
	 		entityManager.merge(usersVO);
		}


		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<UsersVO> findAll() throws Exception {
			// TODO Auto-generated method stub
	 		Query query = entityManager.createQuery("FROM UsersVO o");
			 return query.getResultList();

		}
		
	 
}
