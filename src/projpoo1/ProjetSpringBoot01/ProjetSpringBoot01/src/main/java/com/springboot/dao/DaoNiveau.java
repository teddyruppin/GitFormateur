package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Niveau;

public interface DaoNiveau extends JpaRepository<Niveau, Long> {

}