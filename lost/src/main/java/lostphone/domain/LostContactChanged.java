package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostContactChanged extends AbstractEvent {

    private Long id;
    private String contact;

    public LostContactChanged(Lost aggregate) {
        super(aggregate);
    }

    public LostContactChanged() {
        super();
    }
}
//>>> DDD / Domain Event
