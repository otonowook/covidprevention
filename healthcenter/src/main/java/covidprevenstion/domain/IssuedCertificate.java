package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class IssuedCertificate extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;

    public IssuedCertificate(Reserve aggregate) {
        super(aggregate);
    }

    public IssuedCertificate() {
        super();
    }
}
//>>> DDD / Domain Event
