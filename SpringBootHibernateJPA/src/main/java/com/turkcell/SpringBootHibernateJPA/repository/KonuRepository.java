package com.turkcell.SpringBootHibernateJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.turkcell.SpringBootHibernateJPA.model.Konu;


public interface KonuRepository extends JpaRepository<Konu, Long> {

}
