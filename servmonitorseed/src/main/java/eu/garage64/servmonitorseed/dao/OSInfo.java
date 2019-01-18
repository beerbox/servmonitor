package eu.garage64.servmonitorseed.dao;

public class OSInfo {

    private String machineName = "unknown";
    private String osArch = "unknown";
    private String osName = "unknown";

    public OSInfo(String machineName, String osArch, String osName) {
        this.machineName = machineName;
        this.osArch = osArch;
        this.osName = osName;
    }

    public OSInfo(){

    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
