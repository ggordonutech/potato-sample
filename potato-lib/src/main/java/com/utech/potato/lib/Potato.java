package com.utech.potato.lib;

public class Potato {
	private int id;
	private String name;
	private float cost;
	private float weightInLbs;
	
	
	public Potato() {
		this(0,"",0.0f);
	}


	public Potato(int id, String name, float weightInLbs) {
		super();
		this.id = id;
		this.name = name;
		this.weightInLbs = weightInLbs;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	


	public float getWeightInLbs() {
		return weightInLbs;
	}


	public void setWeightInLbs(float weightInLbs) {
		this.weightInLbs = weightInLbs;
	}


	@Override
	public String toString() {
		return "Potato [id=" + id + ", name=" + name + ", weight (lbs)=" + weightInLbs + ", cost=" + cost + "]";
	}
	
	
	
	

}
