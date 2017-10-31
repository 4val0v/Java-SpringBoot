package com.codingdojo.objectmaster;

class Wizard extends Human {
	private int health = 50;
	private int intelligence = 8;
	
	public Wizard() {}
	
	public void heal(Human h) {
		h.setHealth(h.getHealth() + this.intelligence);
	}
	
	public void fireball(Human h) {
		h.setHealth(h.getHealth() - (this.intelligence * 3));
	}
	
}