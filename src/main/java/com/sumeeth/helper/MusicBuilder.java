/**
 * 
 */
package com.sumeeth.helper;

import java.util.Date;

import com.sumeeth.model.Music;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class MusicBuilder {

	private Music musicInfo;

	public MusicBuilder() {
		musicInfo = new Music();
	}

	public MusicBuilder withName(String name) {
		musicInfo.setName(name);
		return this;
	}

	public MusicBuilder withModifiedDate(Date modifiedDate) {
		musicInfo.setModifiedDate(modifiedDate);
		return this;
	}

	public MusicBuilder withSize(long size) {
		musicInfo.setSize(size);
		return this;
	}

	public MusicBuilder withCategory(String category) {
		musicInfo.setCategory(category);
		return this;
	}

	public MusicBuilder withAbsolutePath(String absolutePath) {
		musicInfo.setAbsolutePath(absolutePath);
		return this;
	}

	public Music build() {
		return musicInfo;
	}

}
