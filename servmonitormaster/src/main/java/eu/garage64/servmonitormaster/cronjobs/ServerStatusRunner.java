package eu.garage64.servmonitormaster.cronjobs;

import eu.garage64.servmonitormaster.controllers.ServersStatusController;
import eu.garage64.servmonitormaster.dao.ServerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class ServerStatusRunner {

    private static final Logger log = LoggerFactory.getLogger(ServersStatusController.class);

    @Autowired
    List<String> getServers;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;




    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {


        for(int i=0; i<getServers.size(); i++){
            int finalI = i;
            Thread req = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        ResponseEntity<ServerStatus> o = restTemplate.getForEntity("http://"+getServers.get(finalI).split("\\|")[0]+":8088" + "/status", ServerStatus.class);
//                        System.out.println("Response: "+o.toString());
                        if(o.getStatusCodeValue()==200){
                            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//                        redisTemplate.convertAndSend(o.getBody().getName(), o.getBody());
                            o.getBody().setName(getServers.get(finalI).split("\\|")[0]);
                            valueOperations.set(o.getBody().getName(), o.getBody(), 30, TimeUnit.SECONDS);
//                            System.out.println("Sent to redis");
                        }
                    }catch(Exception e){
                        log.error("Could not not get server status: "+ getServers.get(finalI).split("\\|")[0]);
                    }

                }
            });
            req.setName(getServers.get(i).split("\\|")[1]);
            log.debug("Running: "+req.getName());
            req.start();
        }

    }


}
