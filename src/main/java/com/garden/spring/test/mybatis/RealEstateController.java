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
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/select/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/select/2")
	@ResponseBody
	public List<RealEstate> view2(@RequestParam("rent") int rentPrice){
		
		List<RealEstate> realEstateList = realEstateService.getRentUnder(rentPrice);
		
		return realEstateList;
	}
	
	@RequestMapping("/mybatis/real-estate/select/3")
	@ResponseBody
	public List<RealEstate> view3(@RequestParam("area") int area, @RequestParam("price") int price){
		List<RealEstate> realEstateList = realEstateService.getAreaPrice(area, price);
		return realEstateList;
	}

}
