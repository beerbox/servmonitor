package eu.garage64.servmonitorseed.dao;

public class CpuInfo {

    String name;
    String logCores;
    String phiCores;
    String usage;

    public CpuInfo() {
    }

    public CpuInfo(String name, String logCores, String phiCores, String usage) {
        this.name = name;
        this.logCores = logCores;
        this.phiCores = phiCores;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogCores() {
        return logCores;
    }

    public void setLogCores(String logCores) {
        this.logCores = logCores;
    }

    public String getPhiCores() {
        return phiCores;
    }

    public void setPhiCores(String phiCores) {
        this.phiCores = phiCores;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
