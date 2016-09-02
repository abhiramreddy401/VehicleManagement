package edu.abhi.springmvc.service;

import edu.abhi.springmvc.vo.PaymentVO;


public interface PaymentService {
	public void payment(PaymentVO paymentVO) throws java.lang.Exception;
	public void update(String where,String paidUnpaid) throws java.lang.Exception;
	public String findDueAmount(String where) throws java.lang.Exception;
}
