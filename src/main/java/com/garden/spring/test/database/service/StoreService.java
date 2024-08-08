package com.garden.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.database.domain.Store;
import com.garden.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 정보 리스트 리턴 기능
	public List<Store> getStoreList(){
		// store 테이블 모든 행 조회
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
