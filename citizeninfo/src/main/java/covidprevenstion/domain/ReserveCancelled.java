package covidprevenstion.domain;

import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReserveCancelled extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;
}
