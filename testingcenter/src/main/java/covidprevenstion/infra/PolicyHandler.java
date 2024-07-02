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
    TestRepository testRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReservePlaced'"
    )
    public void wheneverReservePlaced_AddToTestList(
        @Payload ReservePlaced reservePlaced
    ) {
        ReservePlaced event = reservePlaced;
        System.out.println(
            "\n\n##### listener AddToTestList : " + reservePlaced + "\n\n"
        );

        // Sample Logic //
        Test.addToTestList(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReserveCancelled'"
    )
    public void wheneverReserveCancelled_AlertTestCancelled(
        @Payload ReserveCancelled reserveCancelled
    ) {
        ReserveCancelled event = reserveCancelled;
        System.out.println(
            "\n\n##### listener AlertTestCancelled : " +
            reserveCancelled +
            "\n\n"
        );

        // Sample Logic //
        Test.alertTestCancelled(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
