package eu.garage64.servmonitorseed.controllers;


import eu.garage64.servmonitorseed.bashrunners.CpuInfoRunner;
import eu.garage64.servmonitorseed.bashrunners.DiskInfoRunner;
import eu.garage64.servmonitorseed.bashrunners.MemoryRunner;
import eu.garage64.servmonitorseed.bashrunners.OSInfoRunner;
import eu.garage64.servmonitorseed.dao.CpuInfo;
import eu.garage64.servmonitorseed.dao.OSInfo;
import eu.garage64.servmonitorseed.dao.ServerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class StatusController {

    private final String UN = "UNKNOWN";

    @Value("${cpuUsageCache.key}")
    private String cacheKey;

    @Autowired
    private HashMap<String,String> appCache;

    @CrossOrigin(origins = "*")
    @GetMapping("/status")
        public ServerStatus getServerStatus() throws IOException, InterruptedException {

        CpuInfo tempCpuInfo = CpuInfoRunner.getCpuDescriptionInfo();
        if(Optional.ofNullable(appCache.get(cacheKey)).isPresent()){
            tempCpuInfo.setUsage(appCache.get(cacheKey));
        }else{
            tempCpuInfo.setUsage("UNKNOWN");
        }


            OSInfo tempOsInfo = OSInfoRunner.getOSInfo();
            ServerStatus ss = new ServerStatus();
            ss.setCpuInfo(tempCpuInfo);
            ss.setOsInfo(tempOsInfo);
            ss.setName(tempOsInfo.getMachineName());
            ss.setMemInfo(MemoryRunner.getMemInfo());
            ss.setTime(LocalDateTime.now());
            ss.setDiskInfo(DiskInfoRunner.getDiskInfo());

            return ss;

        }



}
