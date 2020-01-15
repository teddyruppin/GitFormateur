package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bean.Joueur;

public interface DaoJoueur extends JpaRepository<Joueur, Long> {
	@Query("select j from Joueur j  where email like ?1% ")
	List<Joueur> findByEmail(String email1);
	
}
