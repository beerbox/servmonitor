package eu.garage64.servmonitorseed.bashrunners;

import eu.garage64.servmonitorseed.dao.CpuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CpuInfoRunner {

    public static final String UNKNOWN = "unknown";
    private static final Logger log = LoggerFactory.getLogger(CpuInfoRunner.class);
    public static CpuInfo getCpuDescriptionInfo() throws IOException {
        String logicalCores = UNKNOWN;
        String cpuName = UNKNOWN;
        String physicalCores = UNKNOWN;


        ProcessBuilder pb = new ProcessBuilder( "cat","/proc/cpuinfo").directory(new File("/usr/bin"));
        Process process = pb.start();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            if(line.contains("siblings")){
                try{
                    logicalCores=line.split(":")[1].trim();

                }catch (ArrayIndexOutOfBoundsException ex){
                    ex.printStackTrace();
                    logicalCores="UNKNOWN";
                }
            }
            if(line.contains("model name")){
                try{
                    cpuName=line.split(":")[1].trim();
                }catch(ArrayIndexOutOfBoundsException ex){
                    ex.printStackTrace();
                    cpuName="UNKNOWN";
                }
            }

            if(line.contains("cpu cores")){
                try {
                    physicalCores = line.split(":")[1].trim();
                }catch(ArrayIndexOutOfBoundsException ex){
                    ex.printStackTrace();
                    physicalCores = "UNKNOWN";
                }
            }
            builder.append(line);
            builder.append(System.getProperty("line.separator"));

//            System.out.println(line);
        }

        CpuInfo cpuInfo = new CpuInfo();
        cpuInfo.setName(cpuName);
        cpuInfo.setLogCores(logicalCores);
        cpuInfo.setPhiCores(physicalCores);
        return cpuInfo;
    }
}
