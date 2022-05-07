package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Monster;

@Repository("monsterRepository")
public interface MonsterRepository extends JpaRepository<Monster, String>
{
	public List<Monster> findAll();
	//List<Monster> findAllById(Iterable<String> ids);
	public Monster findMonsterByName(String name);
	
	public <S extends Monster> S save(Monster monster);
	public void delete(Monster monster);
}
