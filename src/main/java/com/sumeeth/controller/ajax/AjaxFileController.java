package com.sumeeth.controller.ajax;

import com.sumeeth.model.Movies;
import com.sumeeth.model.Music;
import com.sumeeth.service.IFilesService;
import com.sumeeth.service.IMoviesService;
import com.sumeeth.service.IMusicService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxFileController {
	Logger log = Logger.getLogger(AjaxFileController.class);
	private IFilesService filesService;
	private IMusicService musicService;
	private IMoviesService moviesService;

	@RequestMapping(value = "/getMusicByLimit_ajax.index", method = RequestMethod.GET)
	public @ResponseBody String getMusicByLimit(
			@RequestParam(value = "offset", required = false) String offset)
			throws Exception {
		List<Music> mList = null;
		if (StringUtils.isEmpty(offset)) {
			mList = musicService.getAllMusic()
					.getMusicInfoList();
		} else {

			mList = musicService.getAllMusicByLimit(
					getActualOffset(
							Integer.parseInt(offset), 10),
					10).getMusicInfoList();
			;
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(mList);
		return json;
	}

	@RequestMapping(value = "/getMoviesByLimit_ajax.index", method = RequestMethod.GET)
	public @ResponseBody String getMoviesByLimit(
			@RequestParam(value = "offset", required = false) String offset)
			throws Exception {
		List<Movies> mList = null;
		if (StringUtils.isEmpty(offset)) {
			mList = moviesService.getAllMovies();

		} else {

			mList = moviesService.getAllMoviesByLimit(
					getActualOffset(
							Integer.parseInt(offset), 10),
					10);
			;
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(mList);
		return json;
	}

	@RequestMapping(value = "/getMusicByName_ajax.index", method = RequestMethod.GET)
	public @ResponseBody String getMusicByName(
			@RequestParam(value = "name", required = true) String name)
			throws Exception {
		List<Music> mList = null;
        if (!StringUtils.isEmpty(name)) {
            mList = musicService.getMusicByName(name)
                    .getMusicInfoList();
        }
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(mList);
		return json;
	}

	@RequestMapping(value = "/updateMusicCategory_ajax.index", method = RequestMethod.POST)
	public @ResponseBody String updateMusicCategory(
			@RequestParam(value = "category", required = true) String category,
			@RequestParam(value = "id", required = true) String id)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean status = false;
		Music music = null;
		if (!StringUtils.isEmpty(category)) {
			musicService.updateMusicCategory(category,
					Integer.parseInt(id));
			music = musicService.getMusicById(Integer
					.parseInt(id));
			if (category.equals(music.getCategory())) {
				status = true;
			}
		}
		map.put("status", status);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(map);
		return json;
	}

	private int getActualOffset(int value, int limit) {

		int maxValue = value * limit;
		log.debug("actual Offset : " + (maxValue - limit));
		return maxValue - limit;

	}

}
