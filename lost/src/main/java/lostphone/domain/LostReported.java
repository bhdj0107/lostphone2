package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostReported extends AbstractEvent {

    private Long id;
    private String status;
    private String contact;
    private String information;
    private Long deviceId;
    private Long memberId;

    public LostReported(Lost aggregate) {
        super(aggregate);
    }

    public LostReported() {
        super();
    }
}
//>>> DDD / Domain Event
