package edu.abhi.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.dao.VehicleRegisterDao;
import edu.abhi.springmvc.vo.EntryVO;
import edu.abhi.springmvc.vo.VehicleDetailsVO;


@Service("VehicleRegisterService")
public class VehicleRegisterServiceImpl implements VehicleRegisterService {

	@Autowired
	VehicleRegisterDao vehicleRegisterDao;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void registerVehicle(VehicleDetailsVO vehicleDetailsVO)
			throws Exception {
		// TODO Auto-generated method stub
		
		vehicleRegisterDao.registerVehicle(vehicleDetailsVO);
		
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void updateVehicle(String assigned, int assignSlot) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public VehicleDetailsVO findById(String vehicleNumber)
			throws Exception {
		// TODO Auto-generated method stub
		return vehicleRegisterDao.findById(vehicleNumber);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<VehicleDetailsVO> findByWhere(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return vehicleRegisterDao.findByWhere(where);
	}

	
	/**
	 * This method is used to Update the new data into Corrosponding Table.
	 * @param ecallInboundGroupsVO A ObjectVO containing the Information about the Corrosponding new VO Object.
	 * @exception Exception on error (if any).
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void updateVehicle(
			VehicleDetailsVO carsnikParkingVehicleDetailsVO)
			throws Exception {
		// TODO Auto-generated method stub
		vehicleRegisterDao.update(carsnikParkingVehicleDetailsVO);
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<EntryVO> findByDate(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return vehicleRegisterDao.findByDate(where);
	}

	
}
