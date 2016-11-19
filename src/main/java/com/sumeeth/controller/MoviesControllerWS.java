package com.sumeeth.controller;

import com.sumeeth.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class MoviesControllerWS extends BaseController {
	Logger log = Logger.getLogger(MoviesControllerWS.class);


	@RequestMapping("/moviesAll.index")
	public String getAllMovies(Map<String, Object> map) {
		final String uri = WEB_SERVICE_BASE_URL+"/movies/showAll";

		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(uri,
				String.class);
		map.putAll(JsonUtil.getMapFormJson(json));
		System.out.println(map);
		log.debug("Map" + map);
		return "defaultView";
	}

	@RequestMapping("/synchMoviesAll.index")
	public String synchMovies(Map<String, Object> map) {
		final String uri =  WEB_SERVICE_BASE_URL+"/movies/synch";
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(uri,
				String.class);
		map.putAll(JsonUtil.getMapFormJson(json));
		log.debug("Map" + map);
		return "defaultView";
	}

	private int getActualOffset(int value, int limit) {

		int maxValue = value * limit;
		log.debug("actual Offset : " + (maxValue - limit));
		return maxValue - limit;

	}

}
