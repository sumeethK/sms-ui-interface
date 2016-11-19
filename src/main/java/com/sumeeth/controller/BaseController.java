package com.sumeeth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Value("${sms.ui.webservice.baseUrl}")
    protected String WEB_SERVICE_BASE_URL;



}
