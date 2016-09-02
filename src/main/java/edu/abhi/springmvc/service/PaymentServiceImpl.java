package edu.abhi.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import edu.abhi.springmvc.dao.PaymentDao;
import edu.abhi.springmvc.vo.PaymentVO;

@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDao paymentDao;
	
	
	@Override
	public void payment(PaymentVO paymentVO)
			throws Exception {
		// TODO Auto-generated method stub
		paymentDao.payment(paymentVO);
		
	}


	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(String where,String paidUnpaid)
			throws Exception {
		// TODO Auto-generated method stub
		paymentDao.update(where,paidUnpaid);
		
			
	}


	@Override
	public String findDueAmount(String where) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.findDueAmount(where);
		
	}
	
	

}
