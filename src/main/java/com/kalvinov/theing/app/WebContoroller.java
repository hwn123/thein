package com.kalvinov.theing.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebContoroller {
    @Value("${nodename}")
    private String nodename;

    @GetMapping("/status")
    @ResponseBody
    public Map<String, String> status(){
        Map<String, String> statusMap = new HashMap();
        statusMap.put("status", "healthy");
        statusMap.put("node_name", nodename);
        return statusMap;
    }
}
