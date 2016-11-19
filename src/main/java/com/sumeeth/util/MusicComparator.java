/**
 * 
 */
package com.sumeeth.util;

import java.util.Comparator;

import com.sumeeth.model.Music;

/**
 * @author sumeeth kumar kanojia
 *
 */
public class MusicComparator implements Comparator<Music> {

	@Override
	public int compare(Music m1, Music m2) {
		return m1.getAbsolutePath().compareTo(
				m2.getAbsolutePath());

	}

}
