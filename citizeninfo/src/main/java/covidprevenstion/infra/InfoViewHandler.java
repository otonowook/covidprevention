package covidprevenstion.infra;

import covidprevenstion.config.kafka.KafkaProcessor;
import covidprevenstion.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class InfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private InfoRepository infoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservePlaced_then_CREATE_1(
        @Payload ReservePlaced reservePlaced
    ) {
        try {
            if (!reservePlaced.validate()) return;

            // view 객체 생성
            Info info = new Info();
            // view 객체에 이벤트의 Value 를 set 함
            info.setRegNmb(reservePlaced.getRegNmb());
            info.setReserveDt(reservePlaced.getReserveDt());
            info.setReserveId(String.valueOf(reservePlaced.getId()));
            // view 레파지 토리에 save
            infoRepository.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAddedToList_then_UPDATE_1(
        @Payload AddedToList addedToList
    ) {
        try {
            if (!addedToList.validate()) return;
            // view 객체 조회
            Optional<Info> infoOptional = infoRepository.findById(addedToList.getRegNmb());

            if (infoOptional.isPresent()) {
                Info info = infoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                info.setTestId(String.valueOf(addedToList.getId()));
                // view 레파지 토리에 save
                infoRepository.save(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTestedOfPositive_then_UPDATE_2(
        @Payload TestedOfPositive testedOfPositive
    ) {
        try {
            if (!testedOfPositive.validate()) return;
            // view 객체 조회
            Optional<Info> infoOptional = infoRepository.findById(testedOfPositive.getRegNmb());

            if (infoOptional.isPresent()) {
                Info info = infoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                info.setStatus("Insfected");
                // view 레파지 토리에 save
                infoRepository.save(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTestedOfNegative_then_UPDATE_3(
        @Payload TestedOfNegative testedOfNegative
    ) {
        try {
            if (!testedOfNegative.validate()) return;
            // view 객체 조회
            Optional<Info> infoOptional = infoRepository.findById(testedOfNegative.getRegNmb());
            if (infoOptional.isPresent()) {
                Info info = infoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                info.setStatus("FALSE");
                // view 레파지 토리에 save
                infoRepository.save(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenIsolated_then_UPDATE_4(@Payload Isolated isolated) {
        try {
            if (!isolated.validate()) return;
            // view 객체 조회
            Optional<Info> infoOptional = infoRepository.findById(isolated.getRegNmb());

            if (infoOptional.isPresent()) {
                Info info = infoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                info.setIsolateDt(isolated.getIsolationDt());
                // view 레파지 토리에 save
                infoRepository.save(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserveCancelled_then_DELETE_1(
        @Payload ReserveCancelled reserveCancelled
    ) {
        try {
            if (!reserveCancelled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            infoRepository.deleteById(reserveCancelled.getRegNmb());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
