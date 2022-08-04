package com.qa.firstSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.firstSpring.models.Cat;
import com.qa.firstSpring.repo.CatRepo;

@Service
public class CatService {
	
	private Cat cat;
	@Autowired
	private CatRepo repo;
	
	@Autowired
	public CatService(CatRepo repo) {
		this.repo = repo;
		cat = new Cat();
		
	}
	
	public Cat createCat(Cat cat) {
		return repo.save(cat);
	}
	
	public List<Cat> createManyCats(List<Cat> cats) {
		return repo.saveAll(cats);
	}
	
	public boolean deleteCat(Long id) {
		Optional<Cat> currentCat = this.repo.findById(id);
		
		boolean isPresent = (currentCat.isPresent()) ? true : false;
		
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}
	
	public Cat updateCat(Cat updateCat, Long id) {  
		Optional<Cat> currentCat = this.repo.findById(id);
	
		if (currentCat.get() instanceof Cat) {
			Cat oldCat = currentCat.get();
			
			oldCat.setAge(updateCat.getAge());
			oldCat.setName(updateCat.getName());
			return repo.save(oldCat);
		}
		
		return null;
	}
	
	public List<Cat> readAllCats() {      
		return this.repo.findAll();  
	}  
	
	public Cat readCat(Long id) {  
		return repo.findById(id).get();  
	}  
}
