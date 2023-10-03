package com.group.express.service;

import com.group.express.domain.BusBooking;
import com.group.express.domain.TrainBooking;
import com.group.express.repository.TrainBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainBookingService {
    private final TrainBookingRepository trainBookingRepository;

    @Autowired
    TrainBookingService(TrainBookingRepository trainBookingRepository){this.trainBookingRepository=trainBookingRepository;}

    public List<TrainBooking> getBusBookingList(String id ){
        return trainBookingRepository.findBookingsById(id);
    }
}
