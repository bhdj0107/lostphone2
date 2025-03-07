package lostphone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import lostphone.config.kafka.KafkaProcessor;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeviceRepository deviceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReported'"
    )
    public void wheneverLostReported_ChangeDeviceStatus(
        @Payload LostReported lostReported
    ) {
        LostReported event = lostReported;
        System.out.println(
            "\n\n##### listener ChangeDeviceStatus : " + lostReported + "\n\n"
        );

        // Sample Logic //
        Device.changeDeviceStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostDeleted'"
    )
    public void wheneverLostDeleted_ChangeDeviceStatus(
        @Payload LostDeleted lostDeleted
    ) {
        LostDeleted event = lostDeleted;
        System.out.println(
            "\n\n##### listener ChangeDeviceStatus : " + lostDeleted + "\n\n"
        );

        // Sample Logic //
        Device.changeDeviceStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
