package eu.garage64.servmonitorseed.bashrunners;

import eu.garage64.servmonitorseed.dao.OSInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSInfoRunner {


    public static OSInfo getOSInfo() throws IOException {


    OSInfo tempOsInfo = new OSInfo();


        /***
         * OS MACHINE NAME
         */

    ProcessBuilder pb = new ProcessBuilder( "uname","-n").directory(new File("/usr/bin"));
    Process process = pb.start();


    BufferedReader reader =
            new BufferedReader(new InputStreamReader(process.getInputStream()));

    String line = null;
        while ( (line = reader.readLine()) != null) {
        tempOsInfo.setMachineName(line.trim());
    }

/****
 * OS ARCH
 */

        ProcessBuilder pbOsArch = new ProcessBuilder( "uname","-i").directory(new File("/usr/bin"));
        Process processOsArch = pbOsArch.start();
        BufferedReader readerOsArch =
                new BufferedReader(new InputStreamReader(processOsArch.getInputStream()));

        String line2 = null;
        while ( (line2 = readerOsArch.readLine()) != null) {
            tempOsInfo.setOsArch(line2.trim());
        }


        /***
         * OS TYPE OF DISTRO
         */

        ProcessBuilder pbOsDistroInfo = new ProcessBuilder( "lsb_release","-d").directory(new File("/usr/bin"));
        Process processOsNameDistro = pbOsDistroInfo.start();
        BufferedReader readerOsNameDistro =
                new BufferedReader(new InputStreamReader(processOsNameDistro.getInputStream()));

        String line3 = null;
        while ( (line3 = readerOsNameDistro.readLine()) != null) {
            try {
                tempOsInfo.setOsName(line3.split(":")[1].trim());
            }catch(ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
                tempOsInfo.setOsName("unknown");
            }


        }


        return tempOsInfo;
    }

}
