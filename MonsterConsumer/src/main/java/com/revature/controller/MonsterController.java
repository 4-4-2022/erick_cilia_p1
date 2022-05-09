package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import com.revature.entities.MonsterDTO;


//this class call the MonsterAPI class as long as it is running
//the MonsterService class has a port of 8080
//this service has a port of 8081
@RestController
@RequestMapping("/monster")
public class MonsterController
{
	@Autowired
	private RestTemplate restTemplate;
	
	//http://localhost:8081/monster/all
	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> findAll(){		
		ResponseEntity<List<Monster>> httpResponse = restTemplate.exchange("http://localhost:8080/monster/all", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Monster>>() {
				});
		return httpResponse.getBody();
	}
	
	//http://localhost:8081/monster/new
	//insert into Postman
	@PostMapping("/new")
	public String createMonster(@RequestBody MonsterDTO monster)
	{
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/monster/new", monster, String.class);
		return response.getBody();
	}
	
	//http://localhost:8081/monster/"monsterName"
	@GetMapping("/{name}")
	public Monster findMonsterByName(@PathVariable String name)
	{
		ResponseEntity<Monster> monster = restTemplate.getForEntity("http://localhost:8080/monster/" + name, Monster.class);
		return monster.getBody();
	}
	
	//http://localhost:8080/monster/"monsterName"
	@DeleteMapping("/{name}")
	public String delete(@PathVariable String name)
	{
		Monster monster = findMonsterByName(name);
		
		restTemplate.delete("http://localhost:8080/monster/" + name);
		return monster.getName();
	}
	
//	@GetMapping("/")
//	public Monster findSightingByMonsterName(@PathVariable String name)
//	{
//		
//	}
	
}
