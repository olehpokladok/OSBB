package com.oleh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oleh.entity.Services;

public interface ServiceRepository extends JpaRepository<Services, Integer>	{
	
	@Query("SELECT s FROM Services s WHERE s.name = :name")
	Services findServiceByName(@Param("name") String name);

	@Query("SELECT s FROM Services s WHERE s.name = :name")
	Services findServiceByNameNew(@Param("name") Services service);
}
