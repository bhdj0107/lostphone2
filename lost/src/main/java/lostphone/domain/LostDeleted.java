package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostDeleted extends AbstractEvent {

    private Long id;

    public LostDeleted(Lost aggregate) {
        super(aggregate);
    }

    public LostDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
