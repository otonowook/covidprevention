package covidprevenstion.domain;

import covidprevenstion.DeliverycenterApplication;
import covidprevenstion.domain.TransferedInspertee;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long regNmb;

    private Date transferDt;

    @PostPersist
    public void onPostPersist() {
        TransferedInspertee transferedInspertee = new TransferedInspertee(this);
        transferedInspertee.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliverycenterApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void insperteeIntoTransfer(
        TestedOfPositive testedOfPositive
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        TransferedInspertee transferedInspertee = new TransferedInspertee(delivery);
        transferedInspertee.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(testedOfPositive.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            TransferedInspertee transferedInspertee = new TransferedInspertee(delivery);
            transferedInspertee.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
