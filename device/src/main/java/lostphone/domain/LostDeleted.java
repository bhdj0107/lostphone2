package lostphone.domain;

import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

@Data
@ToString
public class LostDeleted extends AbstractEvent {

    private Long id;
    private Long deviceId;
}
