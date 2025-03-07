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
public class MemberInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMemberRegisted_then_CREATE_1(
        @Payload MemberRegisted memberRegisted
    ) {
        try {
            if (!memberRegisted.validate()) return;

            // view 객체 생성
            MemberInfo memberInfo = new MemberInfo();
            // view 객체에 이벤트의 Value 를 set 함
            memberInfo.setId(memberRegisted.getId());
            memberInfo.setContact(memberRegisted.getContact());
            memberInfo.setName(memberRegisted.getName());
            // view 레파지 토리에 save
            memberInfoRepository.save(memberInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
