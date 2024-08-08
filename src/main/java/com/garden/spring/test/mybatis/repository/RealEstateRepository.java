package com.garden.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.garden.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int it);
	
	public List<RealEstate> selectRentUnder(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectAreaPrice(@Param("area") int area, @Param("price") int price);
	
}
