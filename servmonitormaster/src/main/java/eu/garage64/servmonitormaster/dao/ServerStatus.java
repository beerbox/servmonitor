package eu.garage64.servmonitormaster.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ServerStatus implements Serializable {

    private String name;
    private CpuInfo cpuInfo;
    private OSInfo osInfo;
    private MemoryInfo memInfo;
    private DiskInfo diskInfo;
    private LocalDateTime time;


    public ServerStatus() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CpuInfo getCpuInfo() {
        return cpuInfo;
    }

    public void setCpuInfo(CpuInfo cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public OSInfo getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(OSInfo osInfo) {
        this.osInfo = osInfo;
    }

    public MemoryInfo getMemInfo() {
        return memInfo;
    }

    public void setMemInfo(MemoryInfo memInfo) {
        this.memInfo = memInfo;
    }


    @JsonFormat(pattern="dd-MM-yyyy@HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DiskInfo getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(DiskInfo diskInfo) {
        this.diskInfo = diskInfo;
    }
}
