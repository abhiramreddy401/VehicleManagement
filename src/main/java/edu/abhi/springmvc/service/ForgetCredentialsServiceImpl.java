package edu.abhi.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.dao.ForgetCredentialsDao;
import edu.abhi.springmvc.vo.ForgetCredentialsVO;

@Service("ForgetCredentialsService")
public class ForgetCredentialsServiceImpl implements ForgetCredentialsService{
	
	@Autowired
	ForgetCredentialsDao forgetCredentialsDao;
		
	@Override
	@Transactional(readOnly=true)
	public String sendCredentials(ForgetCredentialsVO forgetCredentialsVO,String to,String password)
			throws Exception {
		// TODO Auto-generated method stub
		
		return forgetCredentialsDao.sendCredentials(forgetCredentialsVO,to,password);
		
	}

	
	

}
