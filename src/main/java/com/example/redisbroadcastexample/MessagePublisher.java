package com.example.redisbroadcastexample;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MessagePublisher {

    RedisTemplate<String, String> redisTemplate;
    ChannelTopic topic;


    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
        // redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}