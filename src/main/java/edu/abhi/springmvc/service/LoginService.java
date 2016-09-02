package edu.abhi.springmvc.service;

import java.util.List;

import edu.abhi.springmvc.vo.UsersVO;

public interface LoginService {
	
	public List<UsersVO> findAll() throws java.lang.Exception;
	public List<UsersVO> findbyWhere(String where) throws java.lang.Exception; 
	public void update(UsersVO usersVO)throws java.lang.Exception;
}
