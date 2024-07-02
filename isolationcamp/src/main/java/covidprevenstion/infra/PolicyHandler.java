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
    IsolationCampRepository isolationCampRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TransferedInspertee'"
    )
    public void wheneverTransferedInspertee_DeliveryInspertee(
        @Payload TransferedInspertee transferedInspertee
    ) {
        TransferedInspertee event = transferedInspertee;
        System.out.println(
            "\n\n##### listener DeliveryInspertee : " +
            transferedInspertee +
            "\n\n"
        );

        // Sample Logic //
        IsolationCamp.deliveryInspertee(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
