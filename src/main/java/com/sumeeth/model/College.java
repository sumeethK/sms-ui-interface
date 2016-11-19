package com.sumeeth.model;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class College {

	private int id;
	private String name;
	private String city;
	
	public College(){}
	/**
	 * @param id collegeID
	 * @param name  college Name
	 * @param city  college city
	 */
	public College(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	

}
