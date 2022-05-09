package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Monster;
import com.revature.entities.Sightings;
import com.revature.repository.SightingRepository;

@Service("sightingService")
public class SightingService
{
	private SightingRepository sightingRepository;

	@Autowired
	public void setSightingRepository(SightingRepository sightingRepository)
	{
		this.sightingRepository = sightingRepository;
	}

	public List<Sightings> findAll()
	{
		return this.sightingRepository.findAll();
	}

	public Sightings findByMonsterName(String name)
	{
		return this.sightingRepository.findByMonsterName(name);
	}

	public void save(Sightings sighting)
	{
		this.sightingRepository.save(sighting);
	}
	
	public void delete(Sightings sighting)
	{
		this.sightingRepository.delete(sighting);
	}
	
}
