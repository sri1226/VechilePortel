package com.alten.VechilePortel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alten.VechilePortel.bean.VechilePortelBean;
import com.alten.VechilePortel.repository.VechilePortelRepository;
import com.alten.VechilePortel.service.VechilePortelService;

@Repository
public class VechilePortelDao implements VechilePortelService{
    @Autowired
	private VechilePortelRepository vechilePortelRepository;
    
    @Override
    public void addVechile(VechilePortelBean vechilePortelBean) {
    	try {
    	//checking for  dublicate  ChassisID 
    	
    	VechilePortelBean checkChassisIdExcists=vechilePortelRepository.findAllById(vechilePortelBean.getChassisId());
    	if(checkChassisIdExcists!=null) {
    	   System.out.println("Record Excist ");	
    	}else {
    	
    	Byte numberOfPassengers=getNumberOfPassengers(vechilePortelBean);
    	vechilePortelBean.setNumberOfPassengers(numberOfPassengers);
    	vechilePortelRepository.save(vechilePortelBean);
    	
    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	}
    

	@Override
	public VechilePortelBean findByVechilechassisId(String chassisId) {
		return vechilePortelRepository.findAllById(chassisId);
	}

	@Override
	public List<VechilePortelBean> getAllVechileInfo() {
		return (List<VechilePortelBean>) vechilePortelRepository.findAll();
		
	}

	@Override
	public void deleteUserById(String chassisId) {
		try {
			VechilePortelBean checkChassisIdExcists=vechilePortelRepository.findAllById(chassisId);
		   if(chassisId!=null) {
			vechilePortelRepository.deleteById(checkChassisIdExcists.getId());
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    @Override
	public void updateVechileInfoById(VechilePortelBean vechilePortelBean, String chassisId) {
    	VechilePortelBean checkChassisIdExcists=vechilePortelRepository.findAllById(chassisId);
    	vechilePortelBean.setId(checkChassisIdExcists.getId());
		Byte numberOfPassengers=getNumberOfPassengers(vechilePortelBean);
		vechilePortelBean.setNumberOfPassengers(numberOfPassengers);
		vechilePortelRepository.save(vechilePortelBean);
	}
	
	private Byte getNumberOfPassengers(VechilePortelBean vechilePortelBean) {
		Byte numberOfPassengers = null;
		if(vechilePortelBean.getType().toLowerCase().contains("car"))
    		numberOfPassengers=4;
    	else if(vechilePortelBean.getType().toLowerCase().contains("bus"))
    		numberOfPassengers=42;
    	else {
    		numberOfPassengers=1;
    	}
		return numberOfPassengers;
		
	}

}
