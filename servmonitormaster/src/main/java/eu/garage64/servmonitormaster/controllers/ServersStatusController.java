package eu.garage64.servmonitormaster.controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.garage64.servmonitormaster.config.Config;
import eu.garage64.servmonitormaster.dao.Server;
import eu.garage64.servmonitormaster.dao.ServerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServersStatusController {

    private static final Logger log = LoggerFactory.getLogger(ServersStatusController.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    Config config;

    @GetMapping("init")
    @CrossOrigin(origins = {"*"})
    List<Server> getServersStatus(){

        List<Server> servList = new ArrayList<>(0);

        for(String serv: config.getServers()){
            Server s = new Server();
            s.setIp(serv.split("\\|")[0]);
            s.setFriendlyName(serv.split("\\|")[1]);
            s.setRefreshRateInSec(serv.split("\\|")[2]);

            servList.add(s);
        }
        return servList;
    }


    @GetMapping("ss")
    @CrossOrigin(origins = {"*"})
    List<Object> getServerStatuses(){
        ArrayList<String> keys = new ArrayList<>(0);
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        for(String serv: config.getServers()){
            keys.add(serv.split("\\|")[0]);
        }
        List<Object>  o =  valueOperations.multiGet(keys);
//        System.out.println("Chuj");
    return o;

    }






    }
