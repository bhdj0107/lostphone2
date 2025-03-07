package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ChangeDeviceInfoCommand {

    private Long id;
    private String name;
    private String information;
}
