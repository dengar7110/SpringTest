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
	
	public List<RealEstate> getRealEstateListByRentPrice(@Param("rentPrice") int rentPrice){
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		return realEstateList;
	};
	
	public List<RealEstate> getRealEstateListByAreaAndPrice(@Param("area") int area, @Param("price") int price){
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	public int addRealEstate(RealEstate realEstate) {
		int count = realEstateRepository.insertRealEstate(realEstate);
		return count;
	}
	
	public int addRealEstateByRealtorId(int realtorId, RealEstate realEstate) {
		int count = realEstateRepository.insertRealEstateByRealtorId(realtorId, realEstate);
		return count;
	}
	
	public int updateRealEstateById(int id) {
		int count = realEstateRepository.updateRealEstateById(id);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = realEstateRepository.delectRealEstate(id);
		return count;
	}
	
	
}
