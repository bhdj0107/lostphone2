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

        DeviceDeleted deviceDeleted = new DeviceDeleted(this);
        deviceDeleted.publishAfterCommit();

        DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(this);
        deviceStatusChanged.publishAfterCommit();
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

        DeviceInfoChanged deviceInfoChanged = new DeviceInfoChanged(this);
        deviceInfoChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void changeDeviceLocation(
        ChangeDeviceLocationCommand changeDeviceLocationCommand
    ) {
        //implement business logic here:

        DeviceLocationChanged deviceLocationChanged = new DeviceLocationChanged(
            this
        );
        deviceLocationChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void changeDeviceStatus(LostReported lostReported) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
        deviceStatusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostReported.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
            deviceStatusChanged.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeDeviceStatus(LostDeleted lostDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
        deviceStatusChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostDeleted.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            DeviceStatusChanged deviceStatusChanged = new DeviceStatusChanged(device);
            deviceStatusChanged.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
