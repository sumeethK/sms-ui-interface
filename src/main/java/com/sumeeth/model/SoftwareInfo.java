/**
 * 
 */
package com.sumeeth.model;

import java.util.Date;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class SoftwareInfo {

	private String name;
	private String category;
	private Date date;
	private Integer size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SoftwareInfo [name=" + name + ", category=" + category
				+ ", date=" + date + ", size=" + size + "]";
	}
	

}
