/**
 * 
 */
package com.sumeeth.helper;

import java.util.Date;

import com.sumeeth.model.Movies;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class MoviesBuilder {

	private Movies moviesInfo;

	public MoviesBuilder() {
		moviesInfo = new Movies();
	}

	public MoviesBuilder withName(String name) {
		moviesInfo.setName(name);
		return this;
	}

	public MoviesBuilder withModifiedDate(Date modifiedDate) {
		moviesInfo.setModifiedDate(modifiedDate);
		return this;
	}

	public MoviesBuilder withSize(long size) {
		moviesInfo.setSize(size);
		return this;
	}

	public MoviesBuilder withCategory(String category) {
		moviesInfo.setCategory(category);
		return this;
	}

	public MoviesBuilder withAbsolutePath(
			String absolutePath) {
		moviesInfo.setAbsolutePath(absolutePath);
		return this;
	}

	public Movies build() {
		return moviesInfo;
	}

}
