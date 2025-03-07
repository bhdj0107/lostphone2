package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.LostApplication;
import lostphone.domain.LostDeleted;
import lostphone.domain.LostReported;

@Entity
@Table(name = "Lost_table")
@Data
//<<< DDD / Aggregate Root
public class Lost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deviceId;

    private Long memberId;

    private String status;

    private String contact;

    private String information;

    @PostPersist
    public void onPostPersist() {
        LostReported lostReported = new LostReported(this);
        lostReported.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        LostDeleted lostDeleted = new LostDeleted(this);
        lostDeleted.publishAfterCommit();
    }

    public static LostRepository repository() {
        LostRepository lostRepository = LostApplication.applicationContext.getBean(
            LostRepository.class
        );
        return lostRepository;
    }

    //<<< Clean Arch / Port Method
    public void changeLostContact(
        ChangeLostContactCommand changeLostContactCommand
    ) {
        //implement business logic here:
        this.contact = changeLostContactCommand.getContact();

        LostContactChanged lostContactChanged = new LostContactChanged(this);
        lostContactChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void changeLostInfo(ChangeLostInfoCommand changeLostInfoCommand) {
        //implement business logic here:
        this.information = changeLostInfoCommand.getInformation();

        LostInfoChanged lostInfoChanged = new LostInfoChanged(this);
        lostInfoChanged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void sendLostDeviceInitializeRequest(
        SendLostDeviceInitializeRequestCommand sendLostDeviceInitializeRequestCommand
    ) {
        //implement business logic here:

        LostDeviceInitializeRequested lostDeviceInitializeRequested = new LostDeviceInitializeRequested(
            this
        );
        lostDeviceInitializeRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void sendLostDeviceBackupRequest(
        SendLostDeviceBackupRequestCommand sendLostDeviceBackupRequestCommand
    ) {
        //implement business logic here:

        LostDeviceBackupRequested lostDeviceBackupRequested = new LostDeviceBackupRequested(
            this
        );
        lostDeviceBackupRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void reportLostDeviceAcquired(
        ReportLostDeviceAcquiredCommand reportLostDeviceAcquiredCommand
    ) {
        //implement business logic here:
        this.status = "ACQUIRED";
        
        LostStatusChanged lostStatusChanged = new LostStatusChanged(this);
        lostStatusChanged.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
