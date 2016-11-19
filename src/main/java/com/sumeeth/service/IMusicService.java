/**
 * 
 */
package com.sumeeth.service;

import com.sumeeth.model.Music;
import com.sumeeth.model.MusicList;

/**
 * @author sumeeth kumar kanojia
 *
 */
public interface IMusicService {

	MusicList getAllMusic();

	int synchMusicFromLocalSytem() throws Exception;

	MusicList getMusicByName(String name);

	void save(Music dto) throws Exception;

	MusicList getAllMusicByLimit(int offSet, int limit);

	int getTotalMusic();

	void updateMusicCategory(String newCategory, int id);

	Music getMusicById(int id);

}
