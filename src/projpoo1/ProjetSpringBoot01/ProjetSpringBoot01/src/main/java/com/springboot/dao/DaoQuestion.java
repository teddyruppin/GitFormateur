package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bean.Question;

public interface DaoQuestion extends JpaRepository<Question, Long> {

}
