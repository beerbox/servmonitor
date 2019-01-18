package eu.garage64.servmonitormaster.config;


import eu.garage64.servmonitormaster.dao.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "observe")
public class Config {

    private List<String> servers = new ArrayList<String>();

    @Bean
    public List<String> getServers() {
//        ArrayList<Server> serverList = new ArrayList<>(0);
//        for(String singleServer : servers){
//            Server tempServer = new Server();
//
//            String[] properties  = singleServer.split("\\|");
//            tempServer.setIp(properties[0]);
//            tempServer.setFriendlyName(properties[1]);
//            tempServer.setRefreshRateInSec(properties[2]);
//            serverList.add(tempServer);
//
//        }
        return this.servers;
    }

}
