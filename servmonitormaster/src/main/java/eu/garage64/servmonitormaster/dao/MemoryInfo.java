package eu.garage64.servmonitormaster.dao;

import java.io.Serializable;

public class MemoryInfo implements Serializable {

    private String memoryTotal;
    private String memoryUsed;
    private String memoryFree;

    public MemoryInfo(String memoryTotal, String memoryUsed, String memoryFree) {
        this.memoryTotal = memoryTotal;
        this.memoryUsed = memoryUsed;
        this.memoryFree = memoryFree;
    }

    public MemoryInfo() {
    }

    public String getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(String memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public String getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(String memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public String getMemoryFree() {
        return memoryFree;
    }

    public void setMemoryFree(String memoryFree) {
        this.memoryFree = memoryFree;
    }
}
