package com.alten.VechilePortel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alten.VechilePortel.bean.VechilePortelBean;
import com.alten.VechilePortel.service.VechilePortelService;

@RestController
public class VechilePortelController {
	@Autowired
	private VechilePortelService vechilePortelService;
	
	@PostMapping("/vechileInfo")
	public ResponseEntity<VechilePortelBean> addVechile(@RequestBody VechilePortelBean vechilePortelBean ) {
		vechilePortelService.addVechile(vechilePortelBean);
        return new ResponseEntity<VechilePortelBean>(vechilePortelBean, HttpStatus.CREATED);
	}
    
	@GetMapping("/vechileInfo/{chassisId}")
	public ResponseEntity<VechilePortelBean> getVechileById(@PathVariable("chassisId") String chassisId) {
		VechilePortelBean vechileById=vechilePortelService.findByVechilechassisId(chassisId);
		if (vechileById == null) {
            return new ResponseEntity<VechilePortelBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VechilePortelBean>(vechileById, HttpStatus.OK);
	}
	@GetMapping("/vechileInfo")
	public ResponseEntity<List<VechilePortelBean>> getAllVechileInfo() {
		 List<VechilePortelBean> allVechileinfo=vechilePortelService.getAllVechileInfo();
		 return new ResponseEntity<List<VechilePortelBean>>(allVechileinfo, HttpStatus.OK);
	}
	
	@DeleteMapping("/vechileInfo/{chassisId}")
    public ResponseEntity<VechilePortelBean> deleteUser(@PathVariable("chassisId") String chassisId){
		VechilePortelBean vechileById=vechilePortelService.findByVechilechassisId(chassisId);
        if (vechileById == null) {
            return new ResponseEntity<VechilePortelBean>(HttpStatus.NOT_FOUND);
        }
        vechilePortelService.deleteUserById(chassisId);
        return new ResponseEntity<VechilePortelBean>(HttpStatus.NO_CONTENT);
    }
	
	@PutMapping("/vechileInfo/{chassisId}")
	public  ResponseEntity<VechilePortelBean> updateVechileInfoById(@RequestBody VechilePortelBean vechilePortelBean,@PathVariable("chassisId") String chassisId ){
		VechilePortelBean vechileById=vechilePortelService.findByVechilechassisId(chassisId);
		if (vechileById == null) {
            return new ResponseEntity<VechilePortelBean>(HttpStatus.NOT_FOUND);
        }
		vechilePortelService.updateVechileInfoById(vechilePortelBean, chassisId);
		 return new ResponseEntity<VechilePortelBean>(vechilePortelBean, HttpStatus.OK);
		
	}
}
