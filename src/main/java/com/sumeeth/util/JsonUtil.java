package com.sumeeth.util;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

	private static final Logger log = Logger
			.getLogger(JsonUtil.class);

	/*public static void main(String[] args) {

		try {

			ObjectMapper mapper = new ObjectMapper();
			String json = FileUtils
					.readFileToString(new File(
							"I:\\workSpaceSpring\\SoftwareManageSystem\\src\\main\\resources\\json\\movies.json"));

			Map<String, Object> map = new HashMap<String, Object>();

			// convert JSON string to Map
			map = mapper
					.readValue(
							json,
							new TypeReference<Map<String, Object>>() {
							});
			System.out.println("page->"
					+ map.get("page_title"));

	*//*		map.entrySet()
					.stream()
					.forEach(
							e -> System.out.println(e
									.getKey()));*//*

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
	public static Map<String, Object> getMapFormJson(
			String json) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			// convert JSON string to Map
			map = mapper
					.readValue(
							json,
							new TypeReference<Map<String, Object>>() {
							});

			log.debug("JSON to MAP Result : " + map);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}
}