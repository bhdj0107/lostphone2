package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceInfoChanged extends AbstractEvent {

    private Long id;
    private String information;

    public DeviceInfoChanged(Device aggregate) {
        super(aggregate);
    }

    public DeviceInfoChanged() {
        super();
    }
}
//>>> DDD / Domain Event
