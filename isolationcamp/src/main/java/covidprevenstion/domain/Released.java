package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Released extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private Boolean isolationDt;

    public Released(IsolationCamp aggregate) {
        super(aggregate);
    }

    public Released() {
        super();
    }
}
//>>> DDD / Domain Event
