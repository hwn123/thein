package com.kalvinov.theing.app;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.google.common.collect.Lists;
import com.kalvinov.theing.app.dao.TheinRepository;
import com.kalvinov.theing.app.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@XRayEnabled
public class WebContoroller {
    @Autowired
    private TheinRepository theinRepository;
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
    @GetMapping("/list")
    @ResponseBody
    public List<Record> listRecords(){
        return Lists.newArrayList(theinRepository.findAll());
    }

    @ResponseBody
    @PostMapping("/addrecord")
    public String addRecord( @RequestParam(name = "record")String record){
        theinRepository.save(new Record(record));
        return "Ok";
    }



}
