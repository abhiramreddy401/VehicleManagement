package edu.abhi.springmvc.dao;

import edu.abhi.springmvc.vo.UsersVO;


public interface UserRegisterDao {
	public void saveUser(UsersVO usersVO) throws java.lang.Exception;

	public UsersVO findUserById(String id);

}
