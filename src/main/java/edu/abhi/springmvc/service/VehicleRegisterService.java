package edu.abhi.springmvc.service;

import java.util.List;

import edu.abhi.springmvc.vo.EntryVO;
import edu.abhi.springmvc.vo.VehicleDetailsVO;

public interface VehicleRegisterService {

	
	public void registerVehicle(VehicleDetailsVO vehicleDetailsVO) throws java.lang.Exception;
	public void updateVehicle(VehicleDetailsVO vehicleDetailsVO)throws java.lang.Exception;
	public void updateVehicle(String assigned,int assign_slot)throws java.lang.Exception;
	public VehicleDetailsVO findById(String vehicleNumber) throws java.lang.Exception;
	public List<VehicleDetailsVO> findByWhere(String where) throws java.lang.Exception;
	public List<EntryVO> findByDate(String where) throws java.lang.Exception;
	
}
