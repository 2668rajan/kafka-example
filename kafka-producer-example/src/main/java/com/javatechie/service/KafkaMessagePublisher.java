package com.javatechie.service;

import com.javatechie.dto.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate template;

    public void sendMessageToTopic(String message){

//        CompletableFuture<SendResult<String, Objects>> future = template.send("javatechie-topic", 3, null, message);
//        future.whenComplete(((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent message=[" + message +
//                        "] with offset = [" + result.getRecordMetadata().offset() + "] on partition : " +
//                            result.getRecordMetadata().partition());
//            } else {
//                System.out.println("Unable to send message = [" +
//                        message + "] due to : " + ex.getMessage());
//            }
//
//        }));


        template.send("javatechie-kafka", 3, null, "hi");
        template.send("javatechie-kafka", 1, null, "hello");
        template.send("javatechie-kafka", 2, null, "welcome");
        template.send("javatechie-kafka", 2, null, "Youtube");
        template.send("javatechie-kafka", 0, null, "Rajan");


    }

    public void sendEventsToTopic(Customer customer) {
        try {

            CompletableFuture<SendResult<String, Object>> future = template.send("javatechie-topic", customer);
            future.whenComplete(((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + customer.toString() +
                            "] with offset = [" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message = [" +
                            customer.toString() + "] due to : " + ex.getMessage());
                }
            }));
        }catch (Exception ex){
            System.out.println("ERROR : "+ex.getMessage());
        }
    }
}
