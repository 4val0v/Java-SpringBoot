package com.codingdojo.objectmaster;

class HumanTest {
	
	public static void main(String[] args) {
		Human human1 = new Human();
		Human human2 = new Human();
		human1.attack(human2);
		System.out.println(human2.getHealth());
	
	}
}