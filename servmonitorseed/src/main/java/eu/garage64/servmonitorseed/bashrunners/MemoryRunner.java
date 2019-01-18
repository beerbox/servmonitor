package eu.garage64.servmonitorseed.bashrunners;


import eu.garage64.servmonitorseed.dao.MemoryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryRunner {

    public static final String UNKNOWN = "unknown";
    private static final Logger log = LoggerFactory.getLogger(MemoryRunner.class);
    public static MemoryInfo getMemInfo() throws IOException {


        String total = UNKNOWN;
        String used = UNKNOWN;
        String free = UNKNOWN;


        ProcessBuilder pb = new ProcessBuilder( "free","-b").directory(new File("/usr/bin"));
        Process process = pb.start();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            if(line.contains("Mem:")){
              String valuesString  = line.split("Mem:")[1].trim();
                //split into array based on spaces
              String[] vals = valuesString.split("\\s+");
              try{
                  total = vals[0];
                  used = vals[1];
                  free = vals[2];
              }catch(ArrayIndexOutOfBoundsException ex){
                  log.error("CANNOT PARSE RESULTS FOR free -th");
                    ex.printStackTrace();
              }


            }
//            System.out.println(line);
        }

        MemoryInfo memInfo = new MemoryInfo();
        memInfo.setMemoryTotal(total);
        memInfo.setMemoryUsed(used);
        memInfo.setMemoryFree(free);
        return memInfo;
    }



}
