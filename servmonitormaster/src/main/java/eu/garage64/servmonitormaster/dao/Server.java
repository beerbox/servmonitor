package eu.garage64.servmonitormaster.dao;

import java.io.Serializable;
import java.util.Objects;

public class Server implements Serializable {

    private String ip;
    private String friendlyName;
    private String refreshRateInSec;

    public Server(String ip, String friendlyName, String refreshRateInSec) {
        this.ip = ip;
        this.friendlyName = friendlyName;
        this.refreshRateInSec = refreshRateInSec;
    }

    public Server() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getRefreshRateInSec() {
        return refreshRateInSec;
    }

    public void setRefreshRateInSec(String refreshRateInSec) {
        this.refreshRateInSec = refreshRateInSec;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Objects.equals(ip, server.ip) &&
                Objects.equals(friendlyName, server.friendlyName) &&
                Objects.equals(refreshRateInSec, server.refreshRateInSec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, friendlyName, refreshRateInSec);
    }

    @Override
    public String toString() {
        return "Server{" +
                "ip='" + ip + '\'' +
                ", friendlyName='" + friendlyName + '\'' +
                ", refreshRateInSec='" + refreshRateInSec + '\'' +
                '}';
    }


}
