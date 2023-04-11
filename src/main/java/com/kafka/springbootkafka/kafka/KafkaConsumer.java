package com.kafka.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics="myTopic", groupId = "myGroup")
	public void consume(String msg) {
		logger.info(String.format("Message received--> %s", msg));
	}

}
