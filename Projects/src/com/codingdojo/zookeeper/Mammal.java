package com.codingdojo.zookeeper;

class Mammal {
	
	private int energyLevel = 100;
	
	public Mammal() {}
	
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
