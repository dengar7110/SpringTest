package com.garden.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.garden.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	// store 테이블 모든 행 조회
	public List<Store> selectStoreList();
	
}
