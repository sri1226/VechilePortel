package com.alten.VechilePortel.service;

import java.util.List;

import com.alten.VechilePortel.bean.VechilePortelBean;

public interface VechilePortelService {
	 void addVechile(VechilePortelBean vechilePortelBean);
	 VechilePortelBean findByVechilechassisId(String chassisId);
	 List<VechilePortelBean> getAllVechileInfo();
	 void deleteUserById(String chassisId);
	 void updateVechileInfoById(VechilePortelBean vechilePortelBean, String chassisId);

}
