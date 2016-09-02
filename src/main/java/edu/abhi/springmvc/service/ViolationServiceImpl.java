package edu.abhi.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.dao.ViolationDao;
import edu.abhi.springmvc.vo.ViolationVO;

@Service("ViolationService")
public class ViolationServiceImpl implements ViolationService {
	
	@Autowired
	private ViolationDao violationDao;
	
	
	
	@Transactional(readOnly=true)
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception {
		
		return violationDao.findbyWhere(where);
	
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveViolation(ViolationVO violationVO)
			throws Exception {
		// TODO Auto-generated method stub
		violationDao.save(violationVO); 
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public List<ViolationVO> findbyId(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return violationDao.findbyId(where);
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public List<ViolationVO> findViolationsCount(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return violationDao.findViolationsCount(where);
		
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateVehicle(
			ViolationVO carsnikParkingViolationVO)
			throws Exception {
		// TODO Auto-generated method stub
		
		violationDao.updateVehicle(carsnikParkingViolationVO);
		
	}

}
