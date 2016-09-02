package edu.abhi.springmvc.dao;

import edu.abhi.springmvc.vo.PaymentVO;


public interface PaymentDao {
	public void payment(PaymentVO carsnikParkingPaymentVO) throws java.lang.Exception;
	public void update(String where,String paidUnpaid) throws java.lang.Exception;
	public String findDueAmount(String where) throws java.lang.Exception;

}
