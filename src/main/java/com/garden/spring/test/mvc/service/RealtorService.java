package com.garden.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.mvc.domain.Realtor;
import com.garden.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		
		return realtorRepository.insertRealtor(realtor);
	}
	
	public Realtor getLastRealtor() {
		Realtor lastRealtor = realtorRepository.selectLastRealtor();
		return lastRealtor;
	}

}
