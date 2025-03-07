package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ChangeDeviceLocationCommand {

    private Long id;
    private String location;
}
