package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.DeviceApplication;
import lostphone.domain.DeviceAssigned;
import lostphone.domain.DeviceDeleted;
import lostphone.domain.DeviceStatusChanged;

@Entity
@Table(name = "Device_table")
@Data
//<<< DDD / Aggregate Root
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String status;

    private String information;

    private String location;

    @PostPersist
    public void onPostPersist() {
        DeviceAssigned deviceAssigned = new DeviceAssigned(this);
        deviceAssigned.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        DeviceDeleted deviceDeleted = new DeviceDeleted(this);
        deviceDeleted.publishAfterCommit();
    }



    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = DeviceApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }

    //<<< Clean Arch / Port Method
    public void changeDeviceInfo(
        ChangeDeviceInfoCommand changeDeviceInfoCommand
    ) {
        //implement business logic here:
        this.name = changeDeviceInfoCommand.getName();
        this.information = changeDeviceInfoCommand.getInformation();

        DeviceInfoChanged deviceInfoChanged = new DeviceInfoChanged(this);
        deviceInfoChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void changeDeviceLocation(
        ChangeDeviceLocationCommand changeDeviceLocationCommand
    ) {
        //implement business logic here:
        this.location = changeDeviceLocationCommand.getLocation();

        DeviceLocationChanged deviceLocationChanged = new DeviceLocationChanged(
            this
        );
        deviceLocationChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void changeDeviceStatus(LostReported lostReported) {
        //implement business logic here:

        /** Example 2:  finding and process */
        repository().findById(lostReported.getDeviceId()).ifPresent(device->{
            
            device.setStatus("SUSPENDED"); // do something
            repository().save(device);

            DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
            deviceStatusChanged.publishAfterCommit();

         });


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeDeviceStatus(LostDeleted lostDeleted) {
        //implement business logic here:


        /** Example 2:  finding and process */
        repository().findById(lostDeleted.getDeviceId()).ifPresent(device->{
            
            device.setStatus("OK"); // do something
            repository().save(device);

            DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
            deviceStatusChanged.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
