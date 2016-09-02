package edu.abhi.springmvc.service;

import java.util.List;

import edu.abhi.springmvc.vo.ViolationVO;

public interface ViolationService {
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception;
	public List<ViolationVO> findbyId(String where) throws java.lang.Exception;
	public void saveViolation(ViolationVO violationVO) throws java.lang.Exception;
	public List<ViolationVO> findViolationsCount(String where) throws java.lang.Exception;
	public void updateVehicle(ViolationVO violationVO)throws java.lang.Exception;
	

}
