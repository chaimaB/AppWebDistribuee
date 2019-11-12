package com.ressourceshumaines.ressouceshumaines.services;

import com.ressourceshumaines.ressouceshumaines.entities.Holiday;
import com.ressourceshumaines.ressouceshumaines.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public Holiday addHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public Holiday getOneHoliday( int id) {
        return holidayRepository.getOne(id);
    }
}
