package com.softserve.message_sender.service;

import com.softserve.message_sender.domain.UserReceipt;
import com.softserve.message_sender.repository.UserReceiptRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaConsumer {

    private final MailService mailService;
    private final UserReceiptRepo userReceiptRepo;

    @KafkaListener(topics = "${kafka.topic.email-receipt}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMailReceipt(UserReceipt userReceipt, ConsumerRecord<String, UserReceipt> record) {
        log.info("Received userReceipt from partition {}", record.partition());

        userReceiptRepo.save(userReceipt);

        mailService.sendReceiptMessage(userReceipt);
    }

    //TODO pushMessage
}