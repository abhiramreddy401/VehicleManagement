package edu.abhi.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.dao.LoginDao;
import edu.abhi.springmvc.vo.UsersVO;


@Service("LoginService")
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	private LoginDao loginDao;
	
	
	
	@Transactional(readOnly=true)
	public List<UsersVO> findbyWhere(String where) throws java.lang.Exception {
		//int x = carsnikLoginDao.findbyWhere(where).size();
		//System.out.println("SIZE:::::::::::::::::::::::::::"+x);
	return loginDao.findbyWhere(where);
	}




	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(UsersVO usersVO) throws Exception {
		// TODO Auto-generated method stub
		loginDao.update(usersVO);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<UsersVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findAll();
	}
	
}
