package edu.abhi.springmvc.dao;

import edu.abhi.springmvc.vo.ForgetCredentialsVO;

public interface ForgetCredentialsDao {
	public String sendCredentials(ForgetCredentialsVO forgetCredentialsVO,String to,String password) throws java.lang.Exception;
}
