package edu.abhi.springmvc.dao;

import java.util.List;

import edu.abhi.springmvc.vo.ViolationVO;

public interface ViolationDao {
	
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception;
	public List<ViolationVO> findbyId(String where) throws java.lang.Exception;
	public void save(ViolationVO violationVO);
	public List<ViolationVO> findViolationsCount(String where) throws java.lang.Exception;
	public void updateVehicle(ViolationVO violationVO)throws java.lang.Exception;
}
