package com.revature.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name="sightings")
public class Sightings
{
	private int numOfSightings;
	private String sightingLocation;
	public Sightings()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Sightings(int numOfSightings, String sightingLocation)
	{
		super();
		this.numOfSightings = numOfSightings;
		this.sightingLocation = sightingLocation;
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
		return Objects.hash(numOfSightings, sightingLocation);
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
		return numOfSightings == other.numOfSightings && Objects.equals(sightingLocation, other.sightingLocation);
	}
	@Override
	public String toString()
	{
		return "Sightings [numOfSightings=" + numOfSightings + ", sightingLocation=" + sightingLocation + "]";
	}
	
	
}
