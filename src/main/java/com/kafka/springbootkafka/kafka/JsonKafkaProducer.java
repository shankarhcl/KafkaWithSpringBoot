package com.kafka.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.springbootkafka.model.User;

@Service
public class JsonKafkaProducer {
	
	@Value("${kafka.topic.json.name}")
	private String topicNameForJson;
	
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMsg(User data) {
		Message<User> msg =  MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, topicNameForJson)
				.build();
		kafkaTemplate.send(msg);
		logger.info(String.format("message sent %s", data.toString()));
	}


}
