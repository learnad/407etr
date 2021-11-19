package com.etr.trip;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {

	public static void main(String[] args) {
		TestMain t = new TestMain();
//		System.out.println(
//				org.apache.lucene.util.SloppyMath.haversinMeters(43.336962, -79.830394, 43.383554, -79.833478));

		Map<String, Employee> map = new HashMap<>();
		map.put("11", new Employee("one"));
		map.put("12", new Employee("two"));
		map.put("13", new Employee("three"));
		map.put("14", new Employee("four"));

		System.out.println(map.values().stream().filter(v -> v.getId() != null).collect(Collectors.toList()).toArray());
	}

}

class Employee {
	private String id;

	public Employee() {
		super();
	}

	public Employee(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
