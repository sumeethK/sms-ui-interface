/**
 * 
 */
package com.sumeeth.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class MusicList {

	private List<Music> MusicList;

	/**
	 * @param fileInfoList
	 */
	public MusicList(List<Music> MusicList) {
		super();
		this.MusicList = MusicList;
	}

	/**
	 * 
	 */
	public MusicList() {
		super();
		MusicList = new ArrayList<Music>();
	}

	/**
	 * @return the MusicList
	 */
	@XmlElement(name = "file")
	public List<Music> getMusicInfoList() {
		return MusicList;
	}

	/**
	 * @param MusicList
	 *            the MusicList to set
	 */
	public void setMusicInfoList(List<Music> MusicList) {
		this.MusicList = MusicList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Music fInfo : MusicList) {
			sb.append(fInfo.toString() + "\n");
		}
		return sb.toString();
	}

}
