package com.oy.springcloud.service.imp;

import com.oy.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

/**
 * @Author OY
 * @Date 2020/10/22
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessionProvicerImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial:" + serial);
        return null;
    }
}
