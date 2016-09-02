package edu.abhi.springmvc.service;

import edu.abhi.springmvc.vo.UsersVO;


public interface UserRegisterService {
	
	public void saveUser(UsersVO usersVO) throws java.lang.Exception;
	
	UsersVO findById(String id);

}
