package com.springcloud;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huijun.ren on 2017/6/26.
 */
@RestController
public class ConsumerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        logger.info("start add...");
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }
}
