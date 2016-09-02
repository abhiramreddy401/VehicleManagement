package edu.abhi.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.dao.UserRegisterDao;
import edu.abhi.springmvc.vo.UsersVO;

@Service("UserRegisterService")
public class UserRegisterServiceImpl implements
		UserRegisterService {

	@Autowired
	UserRegisterDao userRegisterDao;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveUser(UsersVO usersVO)
			throws Exception {
		// TODO Auto-generated method stub
		userRegisterDao.saveUser(usersVO);

	}
	
	public UsersVO findById(String id) {
		
		UsersVO user = userRegisterDao.findUserById(id);
		
		return user;
	}

}
