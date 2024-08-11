package com.garden.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garden.spring.test.mybatis.domain.RealEstate;
import com.garden.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
		
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaAndPrice(@RequestParam("area") int area, @RequestParam("price")int price) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String InsertRealEsate() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstate(realEstate);
		
		return "입력 성공 : " + count;
		
	}
	
	
	@RequestMapping("/insertByRealtorId")
	@ResponseBody
	public String InsertRealEstate2(@RequestParam("realtorId") int realtorId) {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setAddress("썅떼빌리버 오피스텔 814호");
		realEstate.setArea(45);
		realEstate.setType("월세");
		realEstate.setPrice(100000);
		realEstate.setRentPrice(120);
		
		int count = realEstateService.addRealEstateByRealtorId(realtorId, realEstate);
		
		return "입력 성공 : " + count;
	} 
	
	@RequestMapping("/updateById")
	@ResponseBody
	public String UpdateRealEstate(@RequestParam("id")int id) {
		
		int count = realEstateService.updateRealEstateById(id);
		
		return "수정 성공 : " + count;
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int count = realEstateService.deleteRealEstate(id);
		
		return "삭제 성공 : " + count;
	}
			
	
}