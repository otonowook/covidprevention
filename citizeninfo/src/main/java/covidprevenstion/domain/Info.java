package covidprevenstion.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Info_table")
@Data
public class Info {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long regNmb;

    private String reserveId;
    private Date reserveDt;
    private String testId;
    private String status;
    private Date isolateDt;
}
