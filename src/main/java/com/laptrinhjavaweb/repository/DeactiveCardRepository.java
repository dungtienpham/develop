package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.DeactiveCardEntity;
@Repository
public interface DeactiveCardRepository extends JpaRepository<DeactiveCardEntity, String> {
	@Query(value = "SELECT * FROM deactive_card where data_Source = :dataSource", nativeQuery=true) 
	DeactiveCardEntity findByDataSource(@Param("dataSource") String dataSource);
}
