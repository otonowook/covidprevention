package covidprevenstion.domain;

import covidprevenstion.TestingcenterApplication;
import covidprevenstion.domain.AddedToList;
import covidprevenstion.domain.TestedOfNegative;
import covidprevenstion.domain.TestedOfPositive;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Test_table")
@Data
//<<< DDD / Aggregate Root
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long regNmb;

    private String status;

    private Date reserveDt;

    @PostPersist
    public void onPostPersist() {
        TestedOfPositive testedOfPositive = new TestedOfPositive(this);
        testedOfPositive.publishAfterCommit();

        AddedToList addedToList = new AddedToList(this);
        addedToList.publishAfterCommit();

        TestedOfNegative testedOfNegative = new TestedOfNegative(this);
        testedOfNegative.publishAfterCommit();
    }

    public static TestRepository repository() {
        TestRepository testRepository = TestingcenterApplication.applicationContext.getBean(
            TestRepository.class
        );
        return testRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addToTestList(ReservePlaced reservePlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Test test = new Test();
        repository().save(test);

        AddedToList addedToList = new AddedToList(test);
        addedToList.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservePlaced.get???()).ifPresent(test->{
            
            test // do something
            repository().save(test);

            AddedToList addedToList = new AddedToList(test);
            addedToList.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alertTestCancelled(ReserveCancelled reserveCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Test test = new Test();
        repository().save(test);

        */

        /** Example 2:  finding and process
        
        repository().findById(reserveCancelled.get???()).ifPresent(test->{
            
            test // do something
            repository().save(test);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
