package com.garden.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.ajax.domain.Favorite;
import com.garden.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepsitory;
	
	public List<Favorite> getFavortieList() {
		return favoriteRepsitory.selectFavortieList();
	};
	
	public int addFavorite(String name, String url) {
		
		return favoriteRepsitory.insertFavorite(name, url);
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepsitory.selectCountByUrl(url);
		
		if(count != 0) {
			return true;
		}else {
			return false;
		}
	};
	
	public int deleteFavorite(int id) {
		return favoriteRepsitory.deleteFavorite(id);
	};

}
