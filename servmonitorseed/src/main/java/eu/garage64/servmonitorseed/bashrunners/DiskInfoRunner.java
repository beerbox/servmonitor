package eu.garage64.servmonitorseed.bashrunners;

import eu.garage64.servmonitorseed.dao.DiskInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiskInfoRunner {

    public static final String UNKNOWN = "unknown";
    private static final Logger log = LoggerFactory.getLogger(DiskInfoRunner.class);
    public static DiskInfo getDiskInfo() throws IOException {


        String totalSpace = UNKNOWN;
        String percentageUsage = UNKNOWN;
        String avaliable = UNKNOWN;
        String fileSystem = UNKNOWN;
        String used = UNKNOWN;

        ProcessBuilder pb = new ProcessBuilder("sh", "diskusage.sh");
        Process process = pb.start();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {

                //split into array based on spaces
                String[] vals = line.split("\\s+");
                try{
                    if(vals[5].compareToIgnoreCase("/")==0){
                        log.debug("Parsing disk info!");
                        fileSystem = vals[0];
                        totalSpace = vals[1];
                        used = vals[2];
                        avaliable = vals[3];
                        percentageUsage = vals[4];
                    }
                }catch(ArrayIndexOutOfBoundsException ex){
                    log.error("CANNOT PARSE RESULTS FOR disk");
                    ex.printStackTrace();
                }



//            System.out.println(line);
        }

        DiskInfo diskInfo = new DiskInfo();
        diskInfo.setAvaliable(avaliable);
        diskInfo.setFileSystem(fileSystem);
        diskInfo.setPercentageUsage(percentageUsage);
        diskInfo.setTotalSpace(totalSpace);
        diskInfo.setUsed(used);

        return diskInfo;
    }

}
