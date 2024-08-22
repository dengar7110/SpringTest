package com.garden.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.garden.spring.test.ajax.domain.Favorite;
import com.garden.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String favoriteList (Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavortieList();
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
	}
	
	
	@GetMapping("/input")
	public String test01input () {
		return "ajax/favorite/input";
	}

	// API
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> addFaovrite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// json 문자열로 response 에 데이터를 채운다
		// 성공여부
		// {"result":"success"}
		// {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
//	@PostMapping("/check")
//	@ResponseBody
//	public Map<String, String> checkFavoriteUrl(
//			@RequestParam("url") String url
//			, Model model){
//		
//		List<Favorite> favoriteList = favoriteService.getFavortieList();
//		model.addAttribute("favoriteList", favoriteList);
//		
//		Map<String, String> favoriteUrlMap = new HashMap<>();
//		
//		
//		
//		for(int i = 0; i< favoriteList.size(); i++) {
//			Favorite urls = favoriteList.get(i);
//			favoriteUrlMap.put("url", urls);
//		}
//		
//		
//		return Map
//	}
	
	
}
