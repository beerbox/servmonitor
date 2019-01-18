package eu.garage64.servmonitorseed;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
@ComponentScan
@Configuration
public class ServmonitorApplication {

    @Value("${cpuUsageCache.key}")
    private String cacheKey;

    @Bean
    public Map<String,String> appCache() {
        Map<String,String> cache = new HashMap<>(0);
        return cache;
    }


    public static void main(String[] args) {


/***
 * CREATE INIT BASH SCRIPT THAT RETURNS CURRENT USAGE OF CPU
 */
        try {
            FileWriter fw = new FileWriter("cpuusage.sh");
            fw.write("#!/bin/bash\n");
            fw.append("top -b -n2 -p 1 | fgrep \"Cpu(s)\" | tail -1 | awk -F'id,' -v prefix=\"$prefix\" '{ split($1, vs, \",\"); v=vs[length(vs)]; sub(\"%\", \"\", v); printf \"%s%.1f%%\\n\", prefix, 100 - v }'\n");
            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


        /***
         * CREATE INIT BASH SCRIPT THAT RETURNS CURRENT DISK USAGE
         */
        try {
            FileWriter fw = new FileWriter("diskusage.sh");
            fw.write("#!/bin/bash\n");
            fw.append("df -PH|column -t");
            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }




        SpringApplication.run(ServmonitorApplication.class, args);





    }



}
