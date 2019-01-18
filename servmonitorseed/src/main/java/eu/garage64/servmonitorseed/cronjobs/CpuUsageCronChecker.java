package eu.garage64.servmonitorseed.cronjobs;


import eu.garage64.servmonitorseed.bashrunners.CpuUsageRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CpuUsageCronChecker {

    @Autowired
    CpuUsageRunner cpuUsageRunner;



    private static final Logger log = LoggerFactory.getLogger(CpuUsageCronChecker.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRateString = "${cpuUsage.interval}")
    public void reportCurrentTime() {
        log.debug("Checking cpu now {}", dateFormat.format(new Date()));
        try {
            cpuUsageRunner.getCpuCurrentUsage();
        } catch (IOException e) {
            log.error("IO error during cpu usage check!", dateFormat.format(new Date()));
            e.printStackTrace();
        }
    }
}