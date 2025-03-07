package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MemberLogined extends AbstractEvent {

    private Long id;
    private String name;

    public MemberLogined(Member aggregate) {
        super(aggregate);
    }

    public MemberLogined() {
        super();
    }
}
//>>> DDD / Domain Event
