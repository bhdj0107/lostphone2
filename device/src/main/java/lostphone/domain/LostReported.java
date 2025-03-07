package lostphone.domain;

import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

@Data
@ToString
public class LostReported extends AbstractEvent {

    private Long id;
    private String status;
    private String contact;
    private String information;
    private Long deviceId;
    private Long memberId;
}
