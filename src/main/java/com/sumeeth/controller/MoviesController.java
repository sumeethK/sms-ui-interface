package com.sumeeth.controller;

import com.sumeeth.model.Movies;
import com.sumeeth.service.IMoviesService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MoviesController {
	Logger log = Logger.getLogger(MoviesController.class);


    private IMoviesService moviesService;

	@RequestMapping("/synchMovies.index")
	public String synchMovies(Map<String, Object> map)
			throws Exception {
		List<Movies> mList = moviesService
				.getAllMoviesByLimit(
						getActualOffset(1, 10), 10);
		int rowsAffected = moviesService
				.synchMoviesFromLocalSytem();
		int totalRows = moviesService.getTotalMovies();
		map.put("page_title", "Movies Offline");
		map.put("moviesList", mList);
		map.put("fileType", "movies");
		map.put("rows_affected", rowsAffected);
		map.put("rows_count", totalRows / 10);
		map.put("rows_start", 1);
		map.put("rows_display", 10);
		return "defaultView";
	}

	@RequestMapping("/movies_db.index")
	public String getMusicFromDB(Map<String, Object> map) {
		List<Movies> mList = null;
		mList = moviesService.getAllMoviesByLimit(
				getActualOffset(1, 10), 10);
		int total_rows = moviesService.getTotalMovies();
		log.debug(mList);
		map.put("page_title", "Movies Offline");
		map.put("moviesList", mList);
		map.put("fileType", "movies");
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
