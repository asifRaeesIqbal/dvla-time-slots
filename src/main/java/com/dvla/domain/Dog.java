package com.dvla.domain;

public class Dog extends Animal {
	
	private final static int TIME_REQUIRED = 60; 
	
	public Dog(String name, String telephoneNo, int age) {
		super(name, telephoneNo, age, TIME_REQUIRED);
			
	}

}
