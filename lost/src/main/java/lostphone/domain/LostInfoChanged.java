package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostInfoChanged extends AbstractEvent {

    private Long id;
    private String information;

    public LostInfoChanged(Lost aggregate) {
        super(aggregate);
    }

    public LostInfoChanged() {
        super();
    }
}
//>>> DDD / Domain Event
