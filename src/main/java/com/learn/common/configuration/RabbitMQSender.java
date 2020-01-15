package com.learn.common.configuration;

import com.learn.common.enums.RabbitMQEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import java.util.Map;

@Configuration
public class RabbitMQSender {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Bean
    public Queue testQueue() {
        return new Queue(RabbitMQEnum.TEST.getQueue());
    }

    @Bean
    DirectExchange testExchange(){
        return new DirectExchange(RabbitMQEnum.TEST.getExchange());
    }

    @Bean
    Binding bindingExchangeDirect(@Qualifier("testQueue")Queue queue, @Qualifier("testExchange") DirectExchange exchange){
        return  BindingBuilder.bind(queue).to(exchange).with(RabbitMQEnum.TEST.getRoutingKey());
    }

    public void send(RabbitMQEnum rabbitMQEnum, Object body, Map<String, Object> properties) throws Exception {
        MessageHeaders messageHeaders = new MessageHeaders(properties);
        Message msg = MessageBuilder.createMessage(body, messageHeaders);

        //若使用confirm-callback,必须要配置publisherConfirms
        //如果消息没有到exchange,则confirm回调,ack=false
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack){
                logger.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }else{
                logger.info("消息发送失败:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }
        });

        //若使用return-callback，必须要配置publisherReturns为true,mandatory为true
        //exchange到queue失败,则return回调
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            logger.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
        });

        rabbitTemplate.convertAndSend(rabbitMQEnum.getExchange(), rabbitMQEnum.getRoutingKey(), msg);
    }

}
