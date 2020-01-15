package com.learn.common.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConditionalOnProperty(name="redis.isCluster", havingValue = "true")
@PropertySource("classpath:redis-cluster.properties")
@ConfigurationProperties(prefix = "redis.cluster")
public class RedissonClusterConfig {
    private Integer idleConnectionTimeout;
    private Integer pingTimeout;
    private Integer connectTimeout;
    private Integer timeout;
    private Integer retryAttempts;
    private Integer retryInterval;
    private Integer reconnectionTimeout;
    private Integer failedAttempts;
    private String password;
    private Integer subscriptionsPerConnection;
    private String clientName;
    private String loadBalancer;
    private Integer slaveSubscriptionConnectionMinimumIdleSize;
    private Integer slaveSubscriptionConnectionPoolSize;
    private Integer slaveConnectionMinimumIdleSize;
    private Integer slaveConnectionPoolSize;
    private Integer masterConnectionMinimumIdleSize;
    private Integer masterConnectionPoolSize;
    private String readMode;
    private String[] nodeAddresses;
    private Integer scanInterval;
    private String codec;

    public Integer getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(Integer idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public Integer getPingTimeout() {
        return pingTimeout;
    }

    public void setPingTimeout(Integer pingTimeout) {
        this.pingTimeout = pingTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(Integer retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public Integer getReconnectionTimeout() {
        return reconnectionTimeout;
    }

    public void setReconnectionTimeout(Integer reconnectionTimeout) {
        this.reconnectionTimeout = reconnectionTimeout;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSubscriptionsPerConnection() {
        return subscriptionsPerConnection;
    }

    public void setSubscriptionsPerConnection(Integer subscriptionsPerConnection) {
        this.subscriptionsPerConnection = subscriptionsPerConnection;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLoadBalancer() {
        return loadBalancer;
    }

    public void setLoadBalancer(String loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public Integer getSlaveSubscriptionConnectionMinimumIdleSize() {
        return slaveSubscriptionConnectionMinimumIdleSize;
    }

    public void setSlaveSubscriptionConnectionMinimumIdleSize(Integer slaveSubscriptionConnectionMinimumIdleSize) {
        this.slaveSubscriptionConnectionMinimumIdleSize = slaveSubscriptionConnectionMinimumIdleSize;
    }

    public Integer getSlaveSubscriptionConnectionPoolSize() {
        return slaveSubscriptionConnectionPoolSize;
    }

    public void setSlaveSubscriptionConnectionPoolSize(Integer slaveSubscriptionConnectionPoolSize) {
        this.slaveSubscriptionConnectionPoolSize = slaveSubscriptionConnectionPoolSize;
    }

    public Integer getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(Integer slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    public Integer getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }

    public void setSlaveConnectionPoolSize(Integer slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }

    public Integer getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public void setMasterConnectionMinimumIdleSize(Integer masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public Integer getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public void setMasterConnectionPoolSize(Integer masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public String getReadMode() {
        return readMode;
    }

    public void setReadMode(String readMode) {
        this.readMode = readMode;
    }

    public String[] getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(String[] nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public Integer getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(Integer scanInterval) {
        this.scanInterval = scanInterval;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }
}
