package com.kalvinov.theing.app;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.google.common.collect.Lists;
import com.kalvinov.theing.app.dao.TheinRepository;
import com.kalvinov.theing.app.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@XRayEnabled
public class GeneralService {
    @Autowired
    private TheinRepository theinRepository;
    @Value("${nodename}")
    private String nodename;

    private Map<String, String> status;

    public Map<String, String> getStatus() {
        return status;
    }
    @Transactional
    public List<Record> getRecords(){
        return Lists.newArrayList(theinRepository.findAll());
    }

    public String addRecord( String record){
        theinRepository.save(new Record(record));
        return "Ok";
    }

    public void setStatus(Map<String, String> status) {
        this.status = status;
    }

    @PostConstruct
    private void init(){
        status = new HashMap<String, String>(){{
            put("nodename", nodename);
            put("status", "healthy");
        }};
    }
}
