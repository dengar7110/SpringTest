package com.garden.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garden.spring.test.mvc.domain.Seller;
import com.garden.spring.test.mvc.service.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/mvc/seller/input")
	public String insertSellerView() {
		
		return "/mvc/sellerInput";
	}
	
	@PostMapping("/mvc/seller/input")
	public String insertSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		sellerService.insertSeller(nickname, profileImage, temperature);
		
		return "/mvc/sellerInput";
	}
	

	@GetMapping("/mvc/seller/info")
	public String sellerInfo(Model model, @RequestParam(value = "id", required = false) Integer id) {
		
		if(id == null) {
			Seller seller = sellerService.getLastSeller();
			model.addAttribute("seller", seller);
		}else {
			Seller seller = sellerService.getSellerById(id);
			model.addAttribute("seller", seller);
		}
		
		return "/mvc/sellerInfo";
	}
	

}
