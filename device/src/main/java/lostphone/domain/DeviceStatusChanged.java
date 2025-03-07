package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceStatusChanged extends AbstractEvent {

    private Long id;
    private String status;

    public DeviceStatusChanged(Device aggregate) {
        super(aggregate);
    }

    public DeviceStatusChanged() {
        super();
    }
}
//>>> DDD / Domain Event
