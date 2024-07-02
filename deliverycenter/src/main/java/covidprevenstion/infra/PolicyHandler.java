package covidprevenstion.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import covidprevenstion.config.kafka.KafkaProcessor;
import covidprevenstion.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TestedOfPositive'"
    )
    public void wheneverTestedOfPositive_InsperteeIntoTransfer(
        @Payload TestedOfPositive testedOfPositive
    ) {
        TestedOfPositive event = testedOfPositive;
        System.out.println(
            "\n\n##### listener InsperteeIntoTransfer : " +
            testedOfPositive +
            "\n\n"
        );

        // Sample Logic //
        Delivery.insperteeIntoTransfer(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
