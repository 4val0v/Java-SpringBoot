package com.codingdojo.zookeeper;

class Dragon extends Mammal {
		
	public Dragon() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		System.out.println("Swooosh! *Flap wings*");
		this.setEnergyLevel(this.getEnergyLevel() - 50);
	}
	
	public void eatHumans() {
		this.setEnergyLevel(this.getEnergyLevel() + 25);
	}	
	
	public void attackTown() {
		System.out.println("* Town burning sound *");
		this.setEnergyLevel(this.getEnergyLevel() - 100);
	}	

}