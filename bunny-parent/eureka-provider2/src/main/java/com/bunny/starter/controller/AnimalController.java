package com.bunny.starter.controller;

import com.alibaba.fastjson.JSON;
import com.bunny.starter.entity.QueryAnimalResponse;
import com.bunny.starter.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalController {

    @Autowired
    private PanelService panelService;

    @Value("${server.port}")
    private String nodeId;

    @RequestMapping(path = "/rest/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String queryAnimal() {
        QueryAnimalResponse response = new QueryAnimalResponse();
        response.setStatus("200 OK");
//        response.setNodeId("node 2");
        response.setNodeId(nodeId);
        return JSON.toJSONString(response);
    }
}
