package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TransferedInspertee extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private Date transferDt;

    public TransferedInspertee(Delivery aggregate) {
        super(aggregate);
    }

    public TransferedInspertee() {
        super();
    }
}
//>>> DDD / Domain Event
