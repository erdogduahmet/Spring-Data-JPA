package com.ahmeterdogdu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmeterdogdu.entities.Ogrenci;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Integer> {
	
	public List<Ogrenci> findByFirstNameAndLastName(String firstName, String lastName);
}
