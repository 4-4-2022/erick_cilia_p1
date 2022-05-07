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
import org.springframework.web.client.RestTemplate;

import com.revature.entities.Monster;
import com.revature.service.MonsterService;

@RestController("monsterController")
@RequestMapping("/monster")
public class MonsterController
{
	private MonsterService monsterService;
	private RestTemplate restTemplate;

	@Autowired
	public void setMonsterService(MonsterService monsterService)
	{
		this.monsterService = monsterService;
	}
	
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Monster>> findAll()
	{
		ResponseEntity<List<Monster>> httpResponse = new ResponseEntity<>(this.monsterService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Monster monster)
	{
		//this finally works. we ave to insert the JSON into the body using post
		this.monsterService.save(monster);
//		ResponseEntity<Monster> response = restTemplate.postForEntity("http://localhost:8080/monster", monster, Monster.class);
//		return response.getBody();
	}
	
	
	@GetMapping(value = "/{name}", produces =MediaType.APPLICATION_JSON_VALUE)
	public Monster findMonsterByName(@PathVariable("name") String name)
	{
		
		return this.monsterService.findMonsterbyName(name); 
	}
	
	@DeleteMapping(value = "/{name}", produces =MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("name") Monster monster)
	{
		this.monsterService.delete(monster);
	}
	
}
