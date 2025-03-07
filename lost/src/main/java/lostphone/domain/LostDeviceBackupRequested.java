package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostDeviceBackupRequested extends AbstractEvent {

    private Long id;

    public LostDeviceBackupRequested(Lost aggregate) {
        super(aggregate);
    }

    public LostDeviceBackupRequested() {
        super();
    }
}
//>>> DDD / Domain Event
