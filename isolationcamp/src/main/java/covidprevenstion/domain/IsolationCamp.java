package covidprevenstion.domain;

import covidprevenstion.IsolationcampApplication;
import covidprevenstion.domain.Isolated;
import covidprevenstion.domain.Released;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "IsolationCamp_table")
@Data
//<<< DDD / Aggregate Root
public class IsolationCamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long regNmb;

    private Boolean isolationDt;

    @PostPersist
    public void onPostPersist() {
        Isolated isolated = new Isolated(this);
        isolated.publishAfterCommit();

        Released released = new Released(this);
        released.publishAfterCommit();
    }

    public static IsolationCampRepository repository() {
        IsolationCampRepository isolationCampRepository = IsolationcampApplication.applicationContext.getBean(
            IsolationCampRepository.class
        );
        return isolationCampRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliveryInspertee(
        TransferedInspertee transferedInspertee
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        IsolationCamp isolationCamp = new IsolationCamp();
        repository().save(isolationCamp);

        Isolated isolated = new Isolated(isolationCamp);
        isolated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(transferedInspertee.get???()).ifPresent(isolationCamp->{
            
            isolationCamp // do something
            repository().save(isolationCamp);

            Isolated isolated = new Isolated(isolationCamp);
            isolated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
