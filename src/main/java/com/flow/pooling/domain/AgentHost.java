package com.flow.pooling.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

/**
 * Define agent host info
 *
 * Created by gy@fir.im on 25/04/2017.
 * @Copyright fir.im
 */
public class AgentHost implements Serializable {

    @Id
    private String id;

    /**
     * DO NOT use setMeaningfulId
     * Format: ${type}-${hostName}-${id}
     */
    @Indexed
    private String meaningfulId;

    private String hostName;

    private String hostIp;

    private HostType type;

    private HostStatus status;

    public AgentHost(String hostName, String hostIp, HostType type) {
        this.hostName = hostName;
        this.hostIp = hostIp;
        this.type = type;
        this.status = HostStatus.CREATED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeaningfulId() {
        return meaningfulId;
    }

    public void setMeaningfulId() {
        this.meaningfulId = String.format("%s-%s-%s", type, hostName, id);
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public HostType getType() {
        return type;
    }

    public void setType(HostType type) {
        this.type = type;
    }

    public HostStatus getStatus() {
        return status;
    }

    public void setStatus(HostStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentHost agentHost = (AgentHost) o;
        return id != null ? id.equals(agentHost.id) : agentHost.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
