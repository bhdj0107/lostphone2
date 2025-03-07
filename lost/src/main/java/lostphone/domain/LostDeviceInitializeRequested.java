package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostDeviceInitializeRequested extends AbstractEvent {

    private Long id;

    public LostDeviceInitializeRequested(Lost aggregate) {
        super(aggregate);
    }

    public LostDeviceInitializeRequested() {
        super();
    }
}
//>>> DDD / Domain Event
