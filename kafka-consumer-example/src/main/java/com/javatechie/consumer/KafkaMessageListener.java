package com.javatechie.consumer;

import com.javatechie.dto.Customer;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @KafkaListener(topics="javatechie-topic", groupId = "jt-group")
//    public void consume1(Customer customer){
//        log.info("Consumer consume the message {} : ", customer.toString() );
//    }

    @KafkaListener(topics="javatechie-kafka", groupId = "jt-group",
                    topicPartitions = {@TopicPartition(topic = "javatechie-kafka", partitions = {"2"})})
    public void consume1(String message){
        log.info("Consumer consume the message {} : ", message );
    }

//    @KafkaListener(topics="javatachie-demo1", groupId = "jt=group")
//    public void consume2(String message){
//        log.info("Consumer2 consume the message {} : ", message );
//    }
//
//    @KafkaListener(topics="javatachie-demo1", groupId = "jt=group")
//    public void consume3(String message){
//        log.info("Consumer3 consume the message {} : ", message );
//    }
//
//    @KafkaListener(topics="javatachie-demo1", groupId = "jt=group")
//    public void consume4(String message){
//        log.info("Consumer4 consume the message {} : ", message );
//    }
}
