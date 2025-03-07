package lostphone.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "LostInfo_table")
@Data
public class LostInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long deviceId;
    private Long memberId;
    private String status;
    private String contact;
    private String information;
}
