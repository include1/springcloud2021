package com.zm.springcloud.service.impl;

import com.zm.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

import java.util.UUID;

/**
 * @EnableBinds
 * 生产者者：@output、@Source、@Channel
 * 消费者：@input、@Sink、@StreamListener
 */
@EnableBinding(Source.class)//开启exchange和通过绑定,开启消息的生产通道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*************serial:" + serial);
        return null;
    }
}
