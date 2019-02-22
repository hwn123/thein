package com.kalvinov.theing.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebContoroller {
    @Value("${NODE_NAME}")
    private String node_name;

    @GetMapping("/status")
    @ResponseBody
    public Map<String, String> status(){
        Map<String, String> statusMap = new HashMap();
        statusMap.put("status", "healthy");
        statusMap.put("node_name", node_name);
        return statusMap;
    }
}
