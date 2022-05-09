package com.revature.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="sightings")
public class Sightings
{
	@Id
	@Column(name="monster_name", unique = true, nullable = false)
	private String monsterName;
	
	@Column(name="num_of_sightings", nullable = false)
	private int numOfSightings;
	
	@Column(name="sighting_location", nullable = false)
	private String sightingLocation;

	public Sightings()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Sightings(String monsterName, int numOfSightings, String sightingLocation)
	{
		super();
		this.monsterName = monsterName;
		this.numOfSightings = numOfSightings;
		this.sightingLocation = sightingLocation;
	}

	public String getMonsterName()
	{
		return monsterName;
	}

	public void setMonsterName(String monsterName)
	{
		this.monsterName = monsterName;
	}

	public int getNumOfSightings()
	{
		return numOfSightings;
	}

	public void setNumOfSightings(int numOfSightings)
	{
		this.numOfSightings = numOfSightings;
	}

	public String getSightingLocation()
	{
		return sightingLocation;
	}

	public void setSightingLocation(String sightingLocation)
	{
		this.sightingLocation = sightingLocation;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(monsterName, numOfSightings, sightingLocation);
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
		Sightings other = (Sightings) obj;
		return Objects.equals(monsterName, other.monsterName) && numOfSightings == other.numOfSightings
				&& Objects.equals(sightingLocation, other.sightingLocation);
	}

	@Override
	public String toString()
	{
		return "Sightings [monsterName=" + monsterName + ", numOfSightings=" + numOfSightings + ", sightingLocation="
				+ sightingLocation + "]";
	}
	
}
