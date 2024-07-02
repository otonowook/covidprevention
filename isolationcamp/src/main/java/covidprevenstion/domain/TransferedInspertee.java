package covidprevenstion.domain;

import covidprevenstion.domain.*;
import covidprevenstion.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class TransferedInspertee extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private Date transferDt;
}
