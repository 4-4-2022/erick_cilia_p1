package com.revature.entities;

import java.util.Objects;

public class MonsterDTO
{
	
	private String name;
	private String description;
	private String skill;
	public MonsterDTO()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public MonsterDTO(String name, String description, String skill)
	{
		super();
		this.name = name;
		this.description = description;
		this.skill = skill;
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
		MonsterDTO other = (MonsterDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(skill, other.skill);
	}
	@Override
	public String toString()
	{
		return "MonsterDTO [name=" + name + ", description=" + description + ", skill=" + skill + "]";
	}
	
	
	
	
}
