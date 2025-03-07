package lostphone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import lostphone.config.kafka.KafkaProcessor;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LostInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private LostInfoRepository lostInfoRepository;
    //>>> DDD / CQRS
}
