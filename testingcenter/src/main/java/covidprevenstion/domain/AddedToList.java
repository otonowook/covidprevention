package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AddedToList extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;

    public AddedToList(Test aggregate) {
        super(aggregate);
    }

    public AddedToList() {
        super();
    }
}
//>>> DDD / Domain Event
