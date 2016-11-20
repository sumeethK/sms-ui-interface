package com.sumeeth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Value("${sms.ui.webservice.baseUrl}")
    protected String WEB_SERVICE_BASE_URL;


    @Value("${sms.ui.feature.maintenance.message}")
    protected String FEATURE_UNDER_MAINTENANCE_MESSAGE;

    @Value("${sms.ui.application.maintenance.message}")
    protected String APPLICATION_UNSER_MAINTENANCE_MESSAGE;


}
