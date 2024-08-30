package com.garden.spring.test.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garden.spring.test.jpa.domain.Recruit;
import com.garden.spring.test.jpa.repository.RecruitRepository;

@RestController // @Controller + @Responsebody
@RequestMapping("/jpa/recruit")
public class RecruitController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/test1")
	public Recruit findById() {
		// id 가 8인 공고 조회
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		return recruit;
	}
	
	@GetMapping("/test2")
	public List<Recruit> findByCompanyId(@RequestParam("companyId") int companyId) {
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		return recruitList;
	}
	
	@GetMapping("/test3")
	public List<Recruit> findByPositionAndType() {
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		return recruitList;
	}	
	
	@GetMapping("/test4")
	@ResponseBody
	public List<Recruit> findByTypeOrSalary() {
		List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		return recruitList;
	}
	
	@GetMapping("/test5")
	@ResponseBody
	public List<Recruit> findByTypeOrderBySalaryDesc() {
		List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		return recruitList;
	}
	
	@GetMapping("/test6")
	@ResponseBody
	public List<Recruit> findByRegionAndSalaryBetween () {
		List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		return recruitList;
	}
	
	@GetMapping("/test7")
	@ResponseBody
	public List<Recruit> test7 () {
		List<Recruit> recruitList = recruitRepository.nativeQuery("2026-04-10 00:00:00" , 8100, "정규직");
		return recruitList;
	}
	
}
