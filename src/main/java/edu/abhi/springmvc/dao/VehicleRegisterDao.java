package edu.abhi.springmvc.dao;

import java.util.List;

import edu.abhi.springmvc.vo.EntryVO;
import edu.abhi.springmvc.vo.VehicleDetailsVO;

public interface VehicleRegisterDao {
	public void registerVehicle(VehicleDetailsVO vehicleDetailsVO) throws java.lang.Exception;
	public void updateVehicle(String assigned,int assign_slot)throws java.lang.Exception;
	public VehicleDetailsVO findById(String vehicleNumber) throws java.lang.Exception;
	public List<VehicleDetailsVO> findByWhere(String where);
	public void update(VehicleDetailsVO vehicleDetailsVO);
	public List<EntryVO> findByDate(String where) throws java.lang.Exception;

}
