package edu.abhi.springmvc.service;

import edu.abhi.springmvc.vo.ForgetCredentialsVO;

public interface ForgetCredentialsService {
	
	public String sendCredentials(ForgetCredentialsVO forgetCredentialsVO,String to,String password) throws java.lang.Exception;

}
