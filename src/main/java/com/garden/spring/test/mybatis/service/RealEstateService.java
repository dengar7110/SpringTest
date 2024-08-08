package com.garden.spring.test.mybatis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.mybatis.domain.RealEstate;
import com.garden.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(@Param("id") int id) {
		RealEstate realEsatate = realEstateRepository.selectRealEstate(id);
		return realEsatate;
	}
	
	public List<RealEstate> getRentUnder(@Param("rentPrice") int rentPrice){
		List<RealEstate> realEstateList = realEstateRepository.selectRentUnder(rentPrice);
		return realEstateList;
	};
	
	public List<RealEstate> getAreaPrice(@Param("area") int area, @Param("price") int price){
		List<RealEstate> realEstateList = realEstateRepository.selectAreaPrice(area, price);
		return realEstateList;
	}
	
	
}
