package com.garden.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garden.spring.test.mvc.domain.Realtor;
import com.garden.spring.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/realtorInput";
	}
	
	@PostMapping("/create")
	public String addRealtorByObject(
//			@RequestParam("office") String office
//			, @RequestParam("phoneNumber") String phoneNumber
//			, @RequestParam("address") String address
//			, @RequestParam("grade") String grade
			@ModelAttribute Realtor realtor
			, Model model) {
		
//		Realtor realtor = new Realtor();
//		
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
		realtorService.addRealtor(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "/mvc/realtorInfo";
	}
	

	@GetMapping("/info")
	public String realtorInfo(Model model) {
		Realtor realtor = realtorService.getLastRealtor();
		
		model.addAttribute("realtor", realtor);
		
		return "mvc/realtorInfo";
	}
		

}
