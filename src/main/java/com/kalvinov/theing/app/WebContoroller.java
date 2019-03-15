package com.kalvinov.theing.app;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.kalvinov.theing.app.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@XRayEnabled
@Controller
public class WebContoroller {
    @Autowired GeneralService service;

    @GetMapping("/status")
    @ResponseBody
    public Map<String, String> status(){
        return  service.getStatus();
    }

    @GetMapping("/list")
    @ResponseBody
    @Transactional
    public List<Record> listRecords(){
        return service.getRecords();
    }

    @ResponseBody
    @PostMapping("/addrecord")
    public String addRecord( @RequestParam(name = "record")String record){
        service.addRecord(record);
        return "Ok";
    }



}
