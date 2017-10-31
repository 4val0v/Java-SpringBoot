package com.codingdojo.objectmaster;

class Samurai extends Human {
	
	private int health = 200;
	private static int counter = 0;
	
	public Samurai() {
		counter++;
	}
	
	public void deathBlow(Human h) {
		h.setHealth(0);
		this.setHealth(this.getHealth() / 2);
	}
	
	public void meditate() {
		this.setHealth(this.health + (this.health/2));
	}
	
	public static int howMany() {
		return counter;
	}

}