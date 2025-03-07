package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostStatusChanged extends AbstractEvent {

    private Long id;
    private String status;

    public LostStatusChanged(Lost aggregate) {
        super(aggregate);
    }

    public LostStatusChanged() {
        super();
    }
}
//>>> DDD / Domain Event
