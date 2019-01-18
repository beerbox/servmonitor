package eu.garage64.servmonitorseed.bashrunners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

@Component
public class CpuUsageRunner {

    @Value("${cpuUsageCache.key}")
    private String cacheKey;

    @Autowired
    HashMap<String,String> appCache;

//    top -b -n2 -p 1 | fgrep "Cpu(s)" | tail -1 | awk -F'id,' -v prefix="$prefix" '{ split($1, vs, ","); v=vs[length(vs)]; sub("%", "", v); printf "%s%.1f%%\n", prefix, 100 - v }'

    public void getCpuCurrentUsage() throws IOException {


        ProcessBuilder pb = new ProcessBuilder("sh", "cpuusage.sh");


        Process process = pb.start();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            builder.append(line);
        }

//        System.out.println("Top: "+builder.toString());







//populate cache
        appCache.put(cacheKey, builder.toString());

//        return builder.toString();
    }

}
