package com.alten.VechilePortel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alten.VechilePortel.bean.VechilePortelBean;

public interface VechilePortelRepository extends CrudRepository<VechilePortelBean, Long>{
	@Query(value="select * from vechile_info where chassis_id=?",nativeQuery=true)
	VechilePortelBean findAllById(String chassisId);
	

	

}
