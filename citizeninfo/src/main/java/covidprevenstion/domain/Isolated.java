package covidprevenstion.domain;

import covidprevenstion.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Isolated extends AbstractEvent {

    private Long id;
    private Long regNmb;
    private Boolean isolationDt;
}
