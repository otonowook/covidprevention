package covidprevenstion.domain;

import covidprevenstion.HealthcenterApplication;
import covidprevenstion.domain.IssuedCertificate;
import covidprevenstion.domain.ReserveCancelled;
import covidprevenstion.domain.ReservePlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reserve_table")
@Data
//<<< DDD / Aggregate Root
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long regNmb;

    private String status;

    private Date reserveDt;

    @PostPersist
    public void onPostPersist() {
        ReserveCancelled reserveCancelled = new ReserveCancelled(this);
        reserveCancelled.publishAfterCommit();

        ReservePlaced reservePlaced = new ReservePlaced(this);
        reservePlaced.publishAfterCommit();

        IssuedCertificate issuedCertificate = new IssuedCertificate(this);
        issuedCertificate.publishAfterCommit();
    }

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = HealthcenterApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }

    //<<< Clean Arch / Port Method
    public static void issueCertificate(TestedOfNegative testedOfNegative) {
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        IssuedCertificate issuedCertificate = new IssuedCertificate(reserve);
        issuedCertificate.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(testedOfNegative.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);

            IssuedCertificate issuedCertificate = new IssuedCertificate(reserve);
            issuedCertificate.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
