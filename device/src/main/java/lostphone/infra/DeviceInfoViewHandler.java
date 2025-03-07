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
public class DeviceInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceAssigned_then_CREATE_1(
        @Payload DeviceAssigned deviceAssigned
    ) {
        try {
            if (!deviceAssigned.validate()) return;

            // view 객체 생성
            DeviceInfo deviceInfo = new DeviceInfo();
            // view 객체에 이벤트의 Value 를 set 함
            deviceInfo.setId(deviceAssigned.getId());
            deviceInfo.setName(deviceAssigned.getName());
            deviceInfo.setStatus(deviceAssigned.getStatus());
            deviceInfo.setInformation(deviceAssigned.getInformation());
            deviceInfo.setLocation(deviceAssigned.getLocation());
            // view 레파지 토리에 save
            deviceInfoRepository.save(deviceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceStatusChanged_then_UPDATE_1(
        @Payload DeviceStatusChanged deviceStatusChanged
    ) {
        try {
            if (!deviceStatusChanged.validate()) return;
            // view 객체 조회
            Optional<DeviceInfo> deviceInfoOptional = deviceInfoRepository.findById(
                deviceStatusChanged.getId()
            );

            if (deviceInfoOptional.isPresent()) {
                DeviceInfo deviceInfo = deviceInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceInfo.setStatus(deviceStatusChanged.getStatus());
                // view 레파지 토리에 save
                deviceInfoRepository.save(deviceInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceLocationChanged_then_UPDATE_2(
        @Payload DeviceLocationChanged deviceLocationChanged
    ) {
        try {
            if (!deviceLocationChanged.validate()) return;
            // view 객체 조회
            Optional<DeviceInfo> deviceInfoOptional = deviceInfoRepository.findById(
                deviceLocationChanged.getId()
            );

            if (deviceInfoOptional.isPresent()) {
                DeviceInfo deviceInfo = deviceInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceInfo.setLocation(deviceLocationChanged.getLocation());
                // view 레파지 토리에 save
                deviceInfoRepository.save(deviceInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceDeleted_then_DELETE_1(
        @Payload DeviceDeleted deviceDeleted
    ) {
        try {
            if (!deviceDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            deviceInfoRepository.deleteById(deviceDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
