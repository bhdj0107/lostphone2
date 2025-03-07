package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.MemberApplication;
import lostphone.domain.MemberRegisted;

@Entity
@Table(name = "Member_table")
@Data
//<<< DDD / Aggregate Root
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    private String contact;

    @PostPersist
    public void onPostPersist() {
        MemberRegisted memberRegisted = new MemberRegisted(this);
        memberRegisted.publishAfterCommit();
    }

    public static MemberRepository repository() {
        MemberRepository memberRepository = MemberApplication.applicationContext.getBean(
            MemberRepository.class
        );
        return memberRepository;
    }

    //<<< Clean Arch / Port Method
    public void login(LoginCommand loginCommand) {
        //implement business logic here:

        MemberLogined memberLogined = new MemberLogined(this);
        memberLogined.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
