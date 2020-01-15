package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Partie;

public interface DaoPartie extends JpaRepository<Partie, Long>  {

}
