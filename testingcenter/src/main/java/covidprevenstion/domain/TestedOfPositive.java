package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TestedOfPositive extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;

    public TestedOfPositive(Test aggregate) {
        super(aggregate);
    }

    public TestedOfPositive() {
        super();
    }
}
//>>> DDD / Domain Event
