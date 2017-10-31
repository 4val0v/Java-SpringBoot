package com.codingdojo.zookeeper;

class Mammal {
	
	private int energyLevel;
	
	public Mammal() {}
	
	public Mammal(int energy) {
		setEnergyLevel(energy);
	}
	
	public int displayEnergy() {
		System.out.println(getEnergyLevel());
		return getEnergyLevel();
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
