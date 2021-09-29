package com.adp.billbreaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adp.billbreaker.domain.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Integer>{
	
	

}
