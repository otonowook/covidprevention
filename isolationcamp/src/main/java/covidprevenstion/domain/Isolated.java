package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Isolated extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private Date isolationDt;

    public Isolated(IsolationCamp aggregate) {
        super(aggregate);
    }

    public Isolated() {
        super();
    }
}
//>>> DDD / Domain Event
