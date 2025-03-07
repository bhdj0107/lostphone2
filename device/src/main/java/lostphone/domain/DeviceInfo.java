package lostphone.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "DeviceInfo_table")
@Data
public class DeviceInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String status;
    private String information;
    private String location;
}
