package eu.garage64.servmonitorseed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CacheComponent {

    @Bean
    public HashMap<String,String> cpuUsageCache(){
        return new HashMap<String,String>(0);
    }


}
