package com.group.express.service;

import com.group.express.domain.TrainBooking;
import com.group.express.repository.TrainBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrainBookingService {
    private final TrainBookingRepository trainBookingRepository;

    @Autowired
    TrainBookingService(TrainBookingRepository trainBookingRepository){this.trainBookingRepository=trainBookingRepository;}

    public List<TrainBooking> getTrainBookingList(String id ){
        return trainBookingRepository.findBookingsById(id);
    }
    public List<TrainBooking> getTrainBookingList( ){
        return trainBookingRepository.findAll();
    }
        public void trainTicketSuccess(TrainBooking trainBooking) throws Exception {
            // 결제 정보를 데이터베이스에 저장

                trainBookingRepository.save(trainBooking);

        }

    public List<TrainBooking> getSearchTrainBookingListall(String start,String end,String startDay,String endDay){
        return trainBookingRepository.getSearchTrainBookingListall(start,end,startDay,endDay);
    }
    public List<TrainBooking> getSearchTrainBookingListDay(String startDay,String endDay){
        return trainBookingRepository.getSearchTrainBookingListDay(startDay,endDay);
    }
    public TrainBooking getUsedMileage(String ticketNumber) {
        Optional<TrainBooking> optionalTrainBooking = trainBookingRepository.findMileageById(ticketNumber);
        return optionalTrainBooking.orElse(null);
    }

    @Transactional
    public void deleteTrainBooking(String ticketNumber) {
        trainBookingRepository.deleteById(ticketNumber);
    }
}
