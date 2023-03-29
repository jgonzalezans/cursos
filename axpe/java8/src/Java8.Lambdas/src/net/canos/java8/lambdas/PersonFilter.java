package net.canos.java8.lambdas;

public class PersonFilter {

	private Integer maxAge;
	private Integer minAge;
	private String partialName;

	public PersonFilter(Integer minAge, Integer maxAge, String partialName) {
		super();
		this.maxAge = maxAge;
		this.minAge = minAge;
		this.partialName = partialName;
	}

	boolean test(Person p) {
		if (minAge != null)
			if (p.getAge() < minAge)
				return false;
		if (maxAge != null)
			if (p.getAge() > maxAge)
				return false;
		if (partialName != null)
			if (!p.getName().contains(partialName))
				return false;

		return true;
	}

}