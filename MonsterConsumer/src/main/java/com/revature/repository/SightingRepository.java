package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Sightings;

@Repository("sightingRepository")
public interface SightingRepository extends JpaRepository<Sightings, String>
{
	public List<Sightings> findAll();
	public Sightings findByMonsterName(String name);
	public <S extends Sightings> S save(Sightings sighting);
	public void delete(Sightings sighting);
}
