package com.ahmeterdogdu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahmeterdogdu.entities.Ogrenci;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Integer> {
	
	public List<Ogrenci> findByFirstNameAndLastName(String firstName, String lastName);
	
	//native query false olduğu için HQL yazdık
	@Query(value = "from Ogrenci")
	List<Ogrenci> getOgrenciList();
	
	//native query true olduğu için sql yazdık
	@Query(value = " select * from ogrenci.ogrenci o where o.id= :ogrenciId ", nativeQuery =true )
	Optional<Ogrenci> findOgrenciById(Integer ogrenciId);
}
