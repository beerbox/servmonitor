package eu.garage64.servmonitormaster.dao;

import java.io.Serializable;

public class DiskInfo implements Serializable {

    private String percentageUsage;
    private String totalSpace;
    private String used;
    private String avaliable;
    private String fileSystem;

    public DiskInfo(String percentageUsage, String totalSpace, String used, String avaliable, String fileSystem) {
        this.percentageUsage = percentageUsage;
        this.totalSpace = totalSpace;
        this.used = used;
        this.avaliable = avaliable;
        this.fileSystem = fileSystem;
    }

    public DiskInfo() {
    }

    public String getPercentageUsage() {
        return percentageUsage;
    }

    public void setPercentageUsage(String percentageUsage) {
        this.percentageUsage = percentageUsage;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    public String getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(String fileSystem) {
        this.fileSystem = fileSystem;
    }
}
