package com.sumeeth.model;

import java.util.Date;

/**
 * @author sumeeth kumar kanojia
 * 
 */

public class Music {

	private int id;

	private String name;

	private String category;
	private Date modifiedDate;

	private long size;

	private String absolutePath;

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

	public String toString() {
		return "FileInfo [name=" + name + ", category="
				+ category + ", modifiedDate="
				+ modifiedDate + ", size=" + size
				+ ", absolutePath=" + absolutePath + "]";
	}

}
