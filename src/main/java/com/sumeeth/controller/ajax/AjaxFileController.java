package com.sumeeth.controller.ajax;

import com.sumeeth.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("movies")
public class AjaxFileController extends BaseController {
    Logger log = Logger.getLogger(AjaxFileController.class);

    @RequestMapping(value = "/getMusicByLimit_ajax.index", method = RequestMethod.GET)
    public
    @ResponseBody
    String getMusicByLimit(
            @RequestParam(value = "offset", required = false) String offset)
            throws Exception {

        return FEATURE_UNDER_MAINTENANCE_MESSAGE;
    }

    @RequestMapping(value = "/getMoviesByLimit_ajax.index",
            params = {"limit", "offset"},
            method = RequestMethod.GET)
    public
    @ResponseBody
    String getMoviesByLimit(
            @RequestParam(value = "limit", required = false) String limit,
            @RequestParam(value = "offset", required = false) String offset)
            throws Exception {
        final String uri = WEB_SERVICE_BASE_URL + "/movies/get/" + limit + "/" + offset;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,
                String.class);
    }

    @RequestMapping(value = "/getMusicByName_ajax.index", method = RequestMethod.GET)
    public
    @ResponseBody
    String getMusicByName(
            @RequestParam(value = "name", required = true) String name)
            throws Exception {
        return FEATURE_UNDER_MAINTENANCE_MESSAGE;
    }

    @RequestMapping(value = "/updateMusicCategory_ajax.index", method = RequestMethod.POST)
    public
    @ResponseBody
    String updateMusicCategory(
            @RequestParam(value = "category", required = true) String category,
            @RequestParam(value = "id", required = true) String id)
            throws Exception {
        return FEATURE_UNDER_MAINTENANCE_MESSAGE;

    }

    private int getActualOffset(int value, int limit) {

        int maxValue = value * limit;
        log.debug("actual Offset : " + (maxValue - limit));
        return maxValue - limit;

    }

}
