package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceLocationChanged extends AbstractEvent {

    private Long id;
    private String location;

    public DeviceLocationChanged(Device aggregate) {
        super(aggregate);
    }

    public DeviceLocationChanged() {
        super();
    }
}
//>>> DDD / Domain Event
