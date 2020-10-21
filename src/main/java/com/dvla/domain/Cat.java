package com.dvla.domain;

public class Cat extends Animal {

	private final static int TIME_REQUIRED = 45; 
	
	public Cat(String name, String telephoneNo, int age) {
		super(name, telephoneNo, age, TIME_REQUIRED);
			
	}

}
