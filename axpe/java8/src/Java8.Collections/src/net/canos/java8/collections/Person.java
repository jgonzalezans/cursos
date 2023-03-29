package net.canos.java8.collections;

import java.util.List;

public class Person implements Comparable<Person>{

	private String name;
	private Integer age;
	private Position mainPosition;
	private List<Position> alternativePositions;
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, Integer age, Position pos) {
		super();
		this.name = name;
		this.age = age;
		this.mainPosition = pos;
	}
	
	public Person(String name, Integer age, Position pos, List<Position> alternatives) {
		super();
		this.name = name;
		this.age = age;
		this.mainPosition = pos;
		this.alternativePositions = alternatives;
	}
	
	public static Person eldest(Person p1, Person p2) {
		if(p1.getAge() < p2.getAge()) return p2;
		else return p1;
	}
	
	
	@Override
	public int compareTo(Person p) {
		if(getAge().equals(p.getAge())) return 0;
		else if(getAge() < p.getAge()) return -1;
		else return 1;
	}
	
	public int compareByType(int type, Person p) {
		if(getAge().equals(p.getAge())) return 0;
		else if(getAge() < p.getAge()) return -1;
		else return 1;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Position getMainPosition() {
		return mainPosition;
	}

	public void setMainPosition(Position pos) {
		this.mainPosition = pos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((mainPosition == null) ? 0 : mainPosition.hashCode());
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
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (mainPosition != other.mainPosition)
			return false;
		return true;
	}

	public List<Position> getAlternativePositions() {
		return alternativePositions;
	}

	public void setAlternativePositions(List<Position> alternativePositions) {
		this.alternativePositions = alternativePositions;
	}
	
	

	

}
