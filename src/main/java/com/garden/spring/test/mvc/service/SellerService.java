package com.garden.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.mvc.domain.Seller;
import com.garden.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public int insertSeller(String nickname, String profileImage, double temperature) {
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
	
		return count;
	}
	
	public Seller getLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		return seller;
	}
	
	public Seller getSellerById(int id) {
		Seller seller = sellerRepository.selectSellerById(id);
		return seller;
	}
	
}
