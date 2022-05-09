package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Monster;
import com.revature.entities.Sightings;
import com.revature.service.SightingService;

@RestController("sightingsController")
@RequestMapping("/sightings")
public class SightingsController
{
	private MonsterController monsterController;
	private SightingService sightingService;
	
	
	@Autowired
	public void setSightingService(MonsterController monsterController, SightingService sightingService)
	{
		this.monsterController = monsterController;
		this.sightingService = sightingService;
	}
	
	//this GET request would honestly be useless
	//http://localhost:8081/sightings/all
	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sightings>> findAll()
	{
		ResponseEntity<List<Sightings>> httpResponse = new ResponseEntity<>(this.sightingService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	
	//http://localhost:8081/sightings/"monsterName"
	@GetMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)//http://localhost:8081/sightings/"monsterName"
	public String findBySightingsId(@PathVariable("id") String name)
	{
		
		Monster monster = monsterController.findMonsterByName(name);
		Sightings sighting = sightingService.findByMonsterName(monster.getName());
		
//		if(monster.getName() == sighting.getMonsterName())
//		{
//			return monster.getName() + sighting.getNumOfSightings();
//		}
//		
//		return null;
		
		return  sighting.getMonsterName() + " Sightings:"
				+ "\n" + "Sightings Reported: "+ sighting.getNumOfSightings()
				+ "\n" + "Location: " + sighting.getSightingLocation();
	}
	
	//http://localhost:8081/sightings/new
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Sightings sighting)
	{
		this.sightingService.save(sighting);
	}
	
	//http://localhost:8081/sightings/delete/"monsterName"
	@DeleteMapping(value = "delete/{name}", produces =MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("name") Sightings sighting)
	{
		this.sightingService.delete(sighting);
	}
	
	
}
