package com.kafka.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.springbootkafka.model.USRDATA;
import com.kafka.springbootkafka.model.User;
import com.kafka.springbootkafka.repo.UserRepo;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	@Autowired
	private UserRepo userRepo;

	@KafkaListener(topics="myTopic7", groupId = "myGroup")
	public void consume(User user) {
		logger.info(String.format("Json Message received--> %s", user.toString()));
		USRDATA usrdata = new USRDATA();
		usrdata.setUsrData(user.toString());
		logger.info("usrdata"+usrdata);
		userRepo.save(usrdata);
		logger.info("data saved in DB");

	}
	
	
}
