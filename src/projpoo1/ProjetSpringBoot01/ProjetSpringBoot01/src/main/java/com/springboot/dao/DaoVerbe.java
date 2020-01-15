package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Verbe;

public interface DaoVerbe extends JpaRepository<Verbe, Long> {

}
