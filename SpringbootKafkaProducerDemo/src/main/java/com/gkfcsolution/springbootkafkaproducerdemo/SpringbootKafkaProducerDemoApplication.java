package com.gkfcsolution.springbootkafkaproducerdemo;

import com.gkfcsolution.springbootkafkaproducerdemo.service.Producer.KafkaProducerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
@Slf4j
public class SpringbootKafkaProducerDemoApplication implements ApplicationRunner {

	@Autowired
	private KafkaProducerImpl kafkaProducerImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProducerDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ArrayList<String> animalList = getAnimalList();
		for (String animalName: animalList){
			kafkaProducerImpl.sendMessage(animalName);
			log.info("Successfully sent the Animal Name = {} to the AnimalTopic.",  animalName);
			Thread.sleep(4000);
		}
	}

	private static ArrayList<String> getAnimalList() {
		ArrayList<String> animalList = new ArrayList<>();
		animalList.add("Dog");
		animalList.add("Lion");
		animalList.add("Tiger");
		animalList.add("Snake");
		animalList.add("Cat");
		return animalList;
	}
}
