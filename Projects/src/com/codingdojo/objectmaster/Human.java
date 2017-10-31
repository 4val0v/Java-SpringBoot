package com.codingdojo.objectmaster;

class Human {
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	private int health = 100;
	
	public Human() {}
	
	public void attack(Human attacked) {
		attacked.setHealth(attacked.getHealth() - this.strength);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}