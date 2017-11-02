package com.codingdojo.objectmaster;

class Ninja extends Human {

	private static int stealth = 10;
	
	public Ninja() {}
	
	public void steal(Human s) {
		s.setHealth(s.getHealth() - this.stealth);
		this.setHealth(this.getHealth() + this.stealth);
	}
	
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
	}
	
}