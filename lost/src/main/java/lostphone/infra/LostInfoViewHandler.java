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
    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostReported_then_CREATE_1(
        @Payload LostReported lostReported
    ) {
        try {
            if (!lostReported.validate()) return;

            // view 객체 생성
            LostInfo lostInfo = new LostInfo();
            // view 객체에 이벤트의 Value 를 set 함
            lostInfo.setId(lostReported.getId());
            lostInfo.setDeviceId(lostReported.getDeviceId());
            lostInfo.setMemberId(lostReported.getMemberId());
            lostInfo.setStatus(lostReported.getStatus());
            lostInfo.setContact(lostReported.getContact());
            lostInfo.setInformation(lostReported.getInformation());

            // view 레파지 토리에 save
            lostInfoRepository.save(lostInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostContactChanged_then_UPDATE_1(
        @Payload LostContactChanged lostContactChanged
    ) {
        try {
            if (!lostContactChanged.validate()) return;
            // view 객체 조회
            Optional<LostInfo> lostInfoOptional = lostInfoRepository.findById(
                lostContactChanged.getId()
            );

            if (lostInfoOptional.isPresent()) {
                LostInfo lostInfo = lostInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostInfo.setContact(lostContactChanged.getContact());
                // view 레파지 토리에 save
                lostInfoRepository.save(lostInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostInfoChanged_then_UPDATE_2(
        @Payload LostInfoChanged lostInfoChanged
    ) {
        try {
            if (!lostInfoChanged.validate()) return;
            // view 객체 조회
            Optional<LostInfo> lostInfoOptional = lostInfoRepository.findById(
                lostInfoChanged.getId()
            );

            if (lostInfoOptional.isPresent()) {
                LostInfo lostInfo = lostInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostInfo.setInformation(lostInfoChanged.getInformation());
                // view 레파지 토리에 save
                lostInfoRepository.save(lostInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostStatusChanged_then_UPDATE_3(
        @Payload LostStatusChanged lostStatusChanged
    ) {
        try {
            if (!lostStatusChanged.validate()) return;
            // view 객체 조회
            Optional<LostInfo> lostInfoOptional = lostInfoRepository.findById(
                lostStatusChanged.getId()
            );

            if (lostInfoOptional.isPresent()) {
                LostInfo lostInfo = lostInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostInfo.setStatus("ACQUIRED");
                // view 레파지 토리에 save
                lostInfoRepository.save(lostInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostDeletedthen_DELETE_1(
        @Payload LostDeleted lostDeleted
    ) {
        try {
            if (!lostDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            lostInfoRepository.deleteById(lostDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
