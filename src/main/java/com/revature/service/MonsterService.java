package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Monster;
import com.revature.repository.MonsterRepository;

@Service("monsterService")
public class MonsterService
{
	private MonsterRepository monsterRepository;
	
	@Autowired
	public void setMonsterRepository(MonsterRepository monsterRepository)
	{
		this.monsterRepository = monsterRepository;
	}
	
	public List<Monster> findAll()
	{
		return this.monsterRepository.findAll();
	}
	
	public Monster findMonsterbyName(String name)
	{
		return monsterRepository.findById(name).get();
	}
	
	public void save(Monster monster)
	{
		this.monsterRepository.save(monster);
	}
	
}
