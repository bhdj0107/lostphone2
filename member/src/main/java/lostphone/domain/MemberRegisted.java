package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MemberRegisted extends AbstractEvent {

    private Long id;
    private String name;
    private String password;
    private String contact;

    public MemberRegisted(Member aggregate) {
        super(aggregate);
    }

    public MemberRegisted() {
        super();
    }
}
//>>> DDD / Domain Event
