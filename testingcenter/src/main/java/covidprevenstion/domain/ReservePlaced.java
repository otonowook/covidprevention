package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReservePlaced extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private String status;
    private Date reserveDt;
}
