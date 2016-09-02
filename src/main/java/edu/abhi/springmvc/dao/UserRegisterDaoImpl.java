package edu.abhi.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.vo.UsersVO;

@Repository("UserRegisterDao")
public class UserRegisterDaoImpl implements UserRegisterDao {

	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void saveUser(UsersVO usersVO)
			throws Exception {
		// TODO Auto-generated method stub
		entityManager.persist(usersVO);
		entityManager.flush();

	}


	@Override
	public UsersVO findUserById(String id) {
		Query query = null;
		if(id != null)
			query = entityManager.createQuery("select * FROM UsersVO o WHERE id =" + id);
				
		List<UsersVO> userlist =query.getResultList();
		if(userlist.size() >0){
			return userlist.get(0);
		}
		return null;
	}
	
	

}
