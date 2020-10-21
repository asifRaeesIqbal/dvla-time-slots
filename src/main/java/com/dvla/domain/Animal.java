package com.dvla.domain;

public abstract class Animal {
	
	private String name;
	private String telephoneNo;
	private int age;
	private int timeRequired;
	
	public Animal(String name, String telephoneNo, int age, int timeRequired) {
		super();
		this.name = name;
		this.telephoneNo = telephoneNo;
		this.age = age;
		this.timeRequired = timeRequired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telephoneNo == null) ? 0 : telephoneNo.hashCode());
		result = prime * result + timeRequired;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telephoneNo == null) {
			if (other.telephoneNo != null)
				return false;
		} else if (!telephoneNo.equals(other.telephoneNo))
			return false;
		if (timeRequired != other.timeRequired)
			return false;
		return true;
	}

	
}
