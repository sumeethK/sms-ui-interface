package com.sumeeth.model;

import java.util.Date;

/**
 * @author sumeeth kumar kanojia
 * 
 */

public class Movies {

	protected int id;

	protected String name;

	protected String category;
	protected Date modifiedDate;
	protected long size;
	protected String absolutePath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {

		this.absolutePath = absolutePath.replace("\\", "/");
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name
				+ ", category=" + category
				+ ", modifiedDate=" + modifiedDate
				+ ", size=" + size + ", absolutePath="
				+ absolutePath + "]";
	}

}
