package com.learn.common.enums;

public enum  RabbitMQEnum {

    TEST("testExchange","testQueue","test");

    private String exchange;
    private String queue;
    private String routingKey;

    RabbitMQEnum(String exchange, String queue, String routingKey) {
        this.exchange = exchange;
        this.queue = queue;
        this.routingKey = routingKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getQueue() {
        return queue;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
