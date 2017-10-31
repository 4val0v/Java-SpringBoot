package com.codingdojo.objectmaster;

class SampleTest {
	
	public static void main(String[] args) {
		
		Wizard wizard = new Wizard();
		Ninja ninja = new Ninja();
		Samurai samurai = new Samurai();
		
		ninja.steal(wizard);
		ninja.runAway();
		samurai.deathBlow(ninja);
		samurai.meditate();
		wizard.heal(ninja);
		wizard.fireball(samurai);
		
		Samurai samurai2 = new Samurai();
		Samurai samurai3 = new Samurai();
		
		System.out.println(Samurai.howMany());
		
		samurai3.deathBlow(wizard);
		samurai2.deathBlow(samurai);
		samurai2.deathBlow(samurai2);
		samurai3.deathBlow(samurai3);
		
		System.out.println(wizard.getHealth());
		System.out.println(ninja.getHealth());
		System.out.println(samurai.getHealth());
		
		System.out.println(samurai2.getHealth());
		System.out.println(samurai3.getHealth());
	
	}
}