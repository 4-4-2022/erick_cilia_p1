package com.revature.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "monster")
public class Monster
{
	@Id
	@Column(name = "monster_name", unique = true, nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "monster_skill", nullable = false)
	private String skill;
	
	public Monster(String name, String description, String skill)
	{
		super();
		this.name = name;
		this.description = description;
		this.skill = skill;
	}

	public Monster()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getSkill()
	{
		return skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(description, name, skill);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monster other = (Monster) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(skill, other.skill);
	}

	@Override
	public String toString()
	{
		return "Monster [name=" + name + ", description=" + description + ", skill=" + skill + "]";
	}
	
	
}
