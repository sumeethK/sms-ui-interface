package com.sumeeth.controller;

import com.sumeeth.model.Music;
import com.sumeeth.service.IFilesService;
import com.sumeeth.service.IMusicService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FileController {
	Logger log = Logger.getLogger(FileController.class);
	private IFilesService filesService;
	private IMusicService musicService;

	@RequestMapping("/movies.index")
	public String getMovies(Map<String, Object> map) {
		map.put("page_title", "Movies Offline");
		map.put("moviesList",
				filesService.getAllMovies("movies", "xml")
						.getFileInfoList());
		map.put("persist_link", "/persistMovies.index");
		return "defaultView";
	}

	@RequestMapping("/music.index")
	public String getMusic(Map<String, Object> map) {
		map.put("page_title", "Music Offline");
		map.put("moviesList",
				filesService.getAllMusic("music", "xml")
						.getFileInfoList());
		map.put("persist_link", "/persistMusic.index");
		return "defaultView";
	}

	@RequestMapping("/persistMovies.index")
	public String persistMovies(Map<String, Object> map) {
		filesService.persistFileListToFile(
				filesService.getAllMovies(), "movies",
				"xml");
		map.put("page_title", "Movies Offline");
		map.put("moviesList",
				filesService.getAllMovies("movies", "xml")
						.getFileInfoList());
		map.put("persist_link", "/persistMovies.index");
		return "defaultView";
	}

	@RequestMapping("/persistMusic.index")
	public String persistMusic(Map<String, Object> map) {
		filesService.persistFileListToFile(
				filesService.getAllMusic(), "music", "xml");

		map.put("page_title", "Movies Offline");
		map.put("moviesList",
				filesService.getAllMovies("music", "xml")
						.getFileInfoList());
		map.put("persist_link", "/persistMusic.index");
		return "defaultView";
	}

	@RequestMapping("/synchMusic.index")
	public String synchMusic(Map<String, Object> map)
			throws Exception {
		List<Music> mList = musicService
				.getAllMusicByLimit(getActualOffset(1, 10),
						10).getMusicInfoList();
		int rows_affected = musicService
				.synchMusicFromLocalSytem();
		int total_rows = musicService.getTotalMusic();
		map.put("page_title", "Music Offline");
		map.put("moviesList", mList);
		map.put("fileType", "music");
		map.put("rows_affected", rows_affected);
		map.put("rows_count", total_rows / 10);
		map.put("rows_start", 1);
		map.put("rows_display", 10);

		return "defaultView";
	}

	@RequestMapping("/music_db.index")
	public String getMusicFromDB(Map<String, Object> map) {
		List<Music> mList = null;

		mList = musicService.getAllMusicByLimit(
				getActualOffset(1, 10), 10)
				.getMusicInfoList();
		int total_rows = musicService.getTotalMusic();
		log.debug(mList);
		map.put("page_title", "Music Offline");
		map.put("moviesList", mList);
		map.put("fileType", "music");
		map.put("rows_affected", mList.size());
		map.put("rows_count", total_rows / 10);
		map.put("rows_start", 1);
		map.put("rows_display", 10);
		return "defaultView";
	}

	private int getActualOffset(int value, int limit) {

		int maxValue = value * limit;
		log.debug("actual Offset : " + (maxValue - limit));
		return maxValue - limit;

	}

}
