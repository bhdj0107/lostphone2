package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceDeleted extends AbstractEvent {

    private Long id;

    public DeviceDeleted(Device aggregate) {
        super(aggregate);
    }

    public DeviceDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
