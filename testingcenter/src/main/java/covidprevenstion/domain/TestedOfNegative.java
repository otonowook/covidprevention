package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TestedOfNegative extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;

    public TestedOfNegative(Test aggregate) {
        super(aggregate);
    }

    public TestedOfNegative() {
        super();
    }
}
//>>> DDD / Domain Event
