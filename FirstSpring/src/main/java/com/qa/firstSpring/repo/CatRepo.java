package com.qa.firstSpring.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.firstSpring.models.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long>{

	@Query(value = "SELECT * FROM cat", nativeQuery = true)
	public List<Cat> readAllCats();
	
	@Query(value = "SELECT * FROM cat WHERE name = ?1", nativeQuery = true)
	public List<Cat> sameNameSelect(String name);
}
